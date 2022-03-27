package ds.adam.SmartphoneSecurityApplication;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.InetAddress;
import java.util.Properties;
import javax.jmdns.JmDNS;
import javax.jmdns.ServiceEvent;
import javax.jmdns.ServiceInfo;
import javax.jmdns.ServiceListener;

import ds.adam.SmartphoneSecurityApplication.DoorLockOpen.PassCode;
import ds.adam.SmartphoneSecurityApplication.SmartphoneSecurityApplicationServiceGrpc.SmartphoneSecurityApplicationServiceImplBase;
import ds.adam.VideoDoorbell.VideoDoorbellServer.Listener;
import io.grpc.Server;
import io.grpc.ServerBuilder;
import io.grpc.stub.StreamObserver;

public class SmartphoneSecurityApplicationServer extends SmartphoneSecurityApplicationServiceImplBase {

	public static void main(String[] args) {
		
		//Creating instance of VideoDoorbellServer
		SmartphoneSecurityApplicationServer smartphoneApplicationServer = new SmartphoneSecurityApplicationServer();
		
		Properties prop = smartphoneApplicationServer.getProperties();
		
		smartphoneApplicationServer.registerService(prop);
		
		int port = Integer.valueOf(prop.getProperty("smartphone_service_port"));
		
		try {
			
			Server server = ServerBuilder.forPort(port)
					.addService(smartphoneApplicationServer)
					.build()
					.start();
			
			System.out.println("Video doorbell server starting, listenting on port " + port);
			
			server.awaitTermination();
			
		} catch (IOException e) {
			
			e.printStackTrace();
			
		} catch (InterruptedException e) {
			
			e.printStackTrace();
			
		}
	}
	
	private Properties getProperties() {
		
		Properties prop = null;		
		
		 try (InputStream input = new FileInputStream("src/main/resources/DublinSuburb22.properties")) {

	            prop = new Properties();

	            // load a properties file
	            prop.load(input);

	            // get the property value and print it out
	            System.out.println("SmartphoneSecurityApplication service properies ...");
	            System.out.println("\t service_type: " + prop.getProperty("service_type"));
	            System.out.println("\t smartphone_service_name: " +prop.getProperty("smartphone_service_name"));
	            System.out.println("\t smartphone_service_description: " +prop.getProperty("smartphone_service_description"));
		        System.out.println("\t smartphone_service_port: " +prop.getProperty("smartphone_service_port"));

	        } catch (IOException ex) {
	            ex.printStackTrace();
	        }
	
		 return prop;
	}

	private  void registerService(Properties prop) {
		 try {
	            // Creating a JmDNS instance
	            JmDNS jmdns = JmDNS.create(InetAddress.getLocalHost());
	            
	            String service_type = prop.getProperty("service_type") ;//"_DublinSuburb22._tcp.local.";
	            String smartphone_service_name = prop.getProperty("smartphone_service_name")  ;// "Dublin_Suburb_22";
	            int smartphone_service_port = Integer.valueOf( prop.getProperty("smartphone_service_port") );// #.50051;
	            
	            String smartphone_service_description = prop.getProperty("smartphone_service_description")  ;//"Service for home security system";
	            
	            // Registering a service
	            ServiceInfo serviceInfo = ServiceInfo.create(service_type, smartphone_service_name, smartphone_service_port, smartphone_service_description);
	            jmdns.registerService(serviceInfo);
	            
	            System.out.printf("registering service with type %s and name %s \n", service_type, smartphone_service_name);
	            
	            // Service discovery
	            jmdns.addServiceListener(service_type, new Listener());
	            
	            // Waiting for 1 second
	            Thread.sleep(1000);

	        } catch (IOException e) {
	            System.out.println(e.getMessage());
	        } catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
		}
	}
	
	// Discovery service
	private static class Listener implements ServiceListener{
		
		@Override
	    public void serviceAdded(ServiceEvent event) {
	        System.out.println("Service added: " + event.getInfo());
	    }
	
	    @Override
	    public void serviceRemoved(ServiceEvent event) {
	        System.out.println("Service removed: " + event.getInfo());
	    }
	
	    @Override
	    public void serviceResolved(ServiceEvent event) {
	        System.out.println("Service resolved: " + event.getInfo());
	    }
	}
	
	public void visitorUnlock(DoorRequest request,
			StreamObserver<DoorLockOpen> openObserver) {
		
		System.out.println("Visitor request code number one: " + request.getVisitorRequestCode1() + ". Visitor request code number two: " + request.getVisitorRequestCode2());
		
		//Instantiating enums from proto file
		PassCode visitorPass = PassCode.success;
		PassCode visitorFail = PassCode.failure;
		
		//Initialising variables
		int firstCode = 0;
		int secondCode = 0;
		int codeEntered = 0;
		//DoorLockOpen reply = null;
		PassCode grantAccess = visitorFail;
		
		/* Loop iterates the code values 5 times, giving a value which is multiplied by 5 each time.
		 * An additional response will be stream 6. This will have success or failure, determining if the
		 * code was valid.
		 */
		for(int i = 0; i < 5; i++) {

			firstCode = (request.getVisitorRequestCode1() * 5) + firstCode;
			secondCode = (request.getVisitorRequestCode2() * 5) + secondCode;
			
			codeEntered = firstCode + secondCode;

			//The DoorLockOpen builder should be looking for a value of 25 from the two codes.
			if(codeEntered == 25 && codeEntered != 0) {
				grantAccess = visitorPass;
			} else if (codeEntered != 25 && codeEntered != 0) {
				grantAccess = visitorFail;
			}
			
			DoorLockOpen reply = DoorLockOpen.newBuilder()
					.setUserAccept(codeEntered)
					.setPassCode(grantAccess)
					.build();
			
			System.out.println("The passcode was " + reply.getPassCodeValue());
			
			openObserver.onNext(reply);
			
			try {
				//wait for a second
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		openObserver.onCompleted();
	}
}
