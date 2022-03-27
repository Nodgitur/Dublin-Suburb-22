package ds.adam.VideoDoorbell;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.InetAddress;
import java.util.ArrayList;
import java.util.Properties;
import io.grpc.Server;
import io.grpc.ServerBuilder;
import io.grpc.stub.StreamObserver;
import javax.jmdns.JmDNS;
import javax.jmdns.ServiceEvent;
import javax.jmdns.ServiceInfo;
import javax.jmdns.ServiceListener;

import java.util.concurrent.TimeUnit;

import ds.adam.VideoDoorbell.BellRequest.Visual;
import ds.adam.VideoDoorbell.DoorLockStatus;
import ds.adam.VideoDoorbell.DoorLockTamper;
import ds.adam.VideoDoorbell.VideoDoorbellServiceGrpc.VideoDoorbellServiceImplBase;

public class VideoDoorbellServer extends VideoDoorbellServiceImplBase {
	
	public static void main(String[] args) throws InterruptedException {
		
		//Creating instance of VideoDoorbellServer
		VideoDoorbellServer videodoorbellserver = new VideoDoorbellServer();
		
		Properties prop = videodoorbellserver.getProperties();
		
		videodoorbellserver.registerService(prop);
		
		int port = Integer.valueOf(prop.getProperty("video_doorbell_service_port"));
		
		try {
			
			Server server = ServerBuilder.forPort(port)
					.addService(videodoorbellserver)
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
	            System.out.println("VideoDoorbell service properies ...");
	            System.out.println("\t service_type: " + prop.getProperty("service_type"));
	            System.out.println("\t video_doorbell_service_name: " +prop.getProperty("video_doorbell_service_name"));
	            System.out.println("\t video_doorbell_service_description: " +prop.getProperty("video_doorbell_service_description"));
		        System.out.println("\t video_doorbell_service_port: " +prop.getProperty("video_doorbell_service_port"));

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
	            String video_doorbell_service_name = prop.getProperty("video_doorbell_service_name")  ;// "Dublin_Suburb_22";
	            int video_doorbell_service_port = Integer.valueOf( prop.getProperty("video_doorbell_service_port") );// #.50051;
	            
	            String video_doorbell_service_description = prop.getProperty("video_doorbell_service_description")  ;//"Service for home security system";
	            
	            // Registering a service
	            ServiceInfo serviceInfo = ServiceInfo.create(service_type, video_doorbell_service_name, video_doorbell_service_port, video_doorbell_service_description);
	            jmdns.registerService(serviceInfo);
	            
	            System.out.printf("registering service with type %s and name %s \n", service_type, video_doorbell_service_name);
	            
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
	public static class Listener implements ServiceListener{
		
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
	
	@Override
	public StreamObserver<DoorLockStatus> doorStatus(
			StreamObserver<DoorLockTamper> responseObserver){
		
		return new StreamObserver<DoorLockStatus>() {
			
			ArrayList<Boolean> list = new ArrayList<>();
			
			@Override
			public void onNext(DoorLockStatus doorLockStatus) {
				
				System.out.println("Here is the value of the door lock status " + doorLockStatus.getCheck());
				
				list.add(doorLockStatus.getCheck());
				
				System.out.println("Checked the status of the door lock");
			}
			
			@Override
			public void onError(Throwable t) {
				t.printStackTrace();
			}
			
			@Override
			public void onCompleted() {
				System.out.println("Received doorStatus completed");
				
				Boolean intruderIsPresent;
				
				if(list.contains(true)) {
					intruderIsPresent = false;
				} else {
					intruderIsPresent = true;
				}
				
				DoorLockTamper tamper = DoorLockTamper
						.newBuilder()
						.setIntruder(intruderIsPresent)
						.build();
				
				responseObserver.onNext(tamper);
				
				//Success from the stream
				responseObserver.onCompleted();
			}
		};
	}
	
	public StreamObserver<Video> homeVideo(
			StreamObserver<BellRequest> responseObserver){
		
		return new StreamObserver<Video> () {
			
			int iteratedValue = 0;
			
			/*
			 * This method is to receive a value from the stream.
			 */
			
			@Override
			public void onNext(Video video) {
				
				iteratedValue = iteratedValue + 1;
				
				boolean confirmation = video.getVideoConfimrationFromBell();
				
				System.out.println(confirmation);
				
				//int videoValue = video.getExampleNumber1() + iteratedValue;
				
				Visual goodVisual = Visual.CONNECTED;
				Visual badVisual = Visual.DISCONNECTED;
				
				BellRequest bell;
				
				if(confirmation == true) {
					bell = BellRequest.newBuilder()
						.setConnectionIntervals(iteratedValue)
						.setVisual(goodVisual)
						.build();
					
				} else {
					bell = BellRequest.newBuilder()
						.setConnectionIntervals(iteratedValue)
						.setVisual(badVisual)
						.build();
				
				}
				
				System.out.println(bell.getVisual());
				
				responseObserver.onNext(bell);
			}
			
			@Override
			public void onError(Throwable t) {
				
				//Error from the stream
				t.printStackTrace();
			}
			
			@Override
			public void onCompleted() {
				
				System.out.println("Received homeVideo completed");
				
				//Success from the stream
				responseObserver.onCompleted();
			}
		};
	}
}
