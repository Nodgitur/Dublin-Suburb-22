package ds.adam.VideoDoorbell;

import java.io.IOException;

import ds.adam.VideoDoorbell.CalculateRequest.Operation;
import ds.adam.VideoDoorbell.VideoDoorbellServiceGrpc.VideoDoorbellServiceImplBase;
import io.grpc.Server;
import io.grpc.ServerBuilder;
import io.grpc.stub.StreamObserver;

import javax.jmdns.JmDNS;
import javax.jmdns.ServiceInfo;

public class VideoDoorbellServer extends VideoDoorbellServiceImplBase {
	
	public static void main(String[] args) {
		
		VideoDoorbellServer videoDoorbellService = new VideoDoorbellServer();
		
		int port = 50051;
		
		try {
			
			Server server = ServerBuilder.forPort(port)
					.addService(videoDoorbellService)
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
	
	@Override
	public void calculate(CalculateRequest request, StreamObserver<CalculateResponse> observer) {
		
		float value = Float.NaN;
		
		if(request.getOperation() == Operation.ADDITION) {
	
			//Requesting values
			value = request.getNumber1() + request.getNumber2();
		}
		
		CalculateResponse response = CalculateResponse.newBuilder()
				.setResult(value)
				.setMessage("Nice one man")
				.build();
		
		//Returning message with the calculation
		observer.onNext(response);
		
		//
		observer.onCompleted();
	}
	
	public StreamObserver<Video> homeVideo(StreamObserver<BellRequest> observer){
		
		return new StreamObserver<Video> () {
			
			/*
			 * This method is to receive a value from the stream.
			 */
			
			@Override
			public void onNext(Video video) {
				int iteratedValue = 0;
				
				for(int i = 0; i < 5; i++) {
					
					iteratedValue++;
					
				}
				
				System.out.println("Here is the number from video " + video.getExampleNumber1() + 
						". Here is the iterated number " + iteratedValue);
				
				int videoValue = video.getExampleNumber1() + iteratedValue;
				
				BellRequest bell = BellRequest.newBuilder()
						.setExampleNumber2(videoValue)
						.build();
				
				
				observer.onNext(bell);
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
				observer.onCompleted();
			}
		};
	}
}
