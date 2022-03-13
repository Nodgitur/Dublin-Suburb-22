package ds.adam.VideoDoorbell;

import static io.grpc.MethodDescriptor.generateFullMethodName;
import static io.grpc.stub.ClientCalls.asyncBidiStreamingCall;
import static io.grpc.stub.ClientCalls.asyncClientStreamingCall;
import static io.grpc.stub.ClientCalls.asyncServerStreamingCall;
import static io.grpc.stub.ClientCalls.asyncUnaryCall;
import static io.grpc.stub.ClientCalls.blockingServerStreamingCall;
import static io.grpc.stub.ClientCalls.blockingUnaryCall;
import static io.grpc.stub.ClientCalls.futureUnaryCall;
import static io.grpc.stub.ServerCalls.asyncBidiStreamingCall;
import static io.grpc.stub.ServerCalls.asyncClientStreamingCall;
import static io.grpc.stub.ServerCalls.asyncServerStreamingCall;
import static io.grpc.stub.ServerCalls.asyncUnaryCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedStreamingCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall;

/**
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.15.0)",
    comments = "Source: VideoDoorbell.proto")
public final class VideoDoorbellServiceGrpc {

  private VideoDoorbellServiceGrpc() {}

  public static final String SERVICE_NAME = "VideoDoorbell.VideoDoorbellService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<ds.adam.VideoDoorbell.Video,
      ds.adam.VideoDoorbell.BellRequest> getHomeVideoMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "homeVideo",
      requestType = ds.adam.VideoDoorbell.Video.class,
      responseType = ds.adam.VideoDoorbell.BellRequest.class,
      methodType = io.grpc.MethodDescriptor.MethodType.BIDI_STREAMING)
  public static io.grpc.MethodDescriptor<ds.adam.VideoDoorbell.Video,
      ds.adam.VideoDoorbell.BellRequest> getHomeVideoMethod() {
    io.grpc.MethodDescriptor<ds.adam.VideoDoorbell.Video, ds.adam.VideoDoorbell.BellRequest> getHomeVideoMethod;
    if ((getHomeVideoMethod = VideoDoorbellServiceGrpc.getHomeVideoMethod) == null) {
      synchronized (VideoDoorbellServiceGrpc.class) {
        if ((getHomeVideoMethod = VideoDoorbellServiceGrpc.getHomeVideoMethod) == null) {
          VideoDoorbellServiceGrpc.getHomeVideoMethod = getHomeVideoMethod = 
              io.grpc.MethodDescriptor.<ds.adam.VideoDoorbell.Video, ds.adam.VideoDoorbell.BellRequest>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.BIDI_STREAMING)
              .setFullMethodName(generateFullMethodName(
                  "VideoDoorbell.VideoDoorbellService", "homeVideo"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  ds.adam.VideoDoorbell.Video.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  ds.adam.VideoDoorbell.BellRequest.getDefaultInstance()))
                  .setSchemaDescriptor(new VideoDoorbellServiceMethodDescriptorSupplier("homeVideo"))
                  .build();
          }
        }
     }
     return getHomeVideoMethod;
  }

  private static volatile io.grpc.MethodDescriptor<ds.adam.VideoDoorbell.DoorLockStatus,
      ds.adam.VideoDoorbell.DoorLockTamper> getDoorStatusMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "doorStatus",
      requestType = ds.adam.VideoDoorbell.DoorLockStatus.class,
      responseType = ds.adam.VideoDoorbell.DoorLockTamper.class,
      methodType = io.grpc.MethodDescriptor.MethodType.CLIENT_STREAMING)
  public static io.grpc.MethodDescriptor<ds.adam.VideoDoorbell.DoorLockStatus,
      ds.adam.VideoDoorbell.DoorLockTamper> getDoorStatusMethod() {
    io.grpc.MethodDescriptor<ds.adam.VideoDoorbell.DoorLockStatus, ds.adam.VideoDoorbell.DoorLockTamper> getDoorStatusMethod;
    if ((getDoorStatusMethod = VideoDoorbellServiceGrpc.getDoorStatusMethod) == null) {
      synchronized (VideoDoorbellServiceGrpc.class) {
        if ((getDoorStatusMethod = VideoDoorbellServiceGrpc.getDoorStatusMethod) == null) {
          VideoDoorbellServiceGrpc.getDoorStatusMethod = getDoorStatusMethod = 
              io.grpc.MethodDescriptor.<ds.adam.VideoDoorbell.DoorLockStatus, ds.adam.VideoDoorbell.DoorLockTamper>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.CLIENT_STREAMING)
              .setFullMethodName(generateFullMethodName(
                  "VideoDoorbell.VideoDoorbellService", "doorStatus"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  ds.adam.VideoDoorbell.DoorLockStatus.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  ds.adam.VideoDoorbell.DoorLockTamper.getDefaultInstance()))
                  .setSchemaDescriptor(new VideoDoorbellServiceMethodDescriptorSupplier("doorStatus"))
                  .build();
          }
        }
     }
     return getDoorStatusMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static VideoDoorbellServiceStub newStub(io.grpc.Channel channel) {
    return new VideoDoorbellServiceStub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static VideoDoorbellServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    return new VideoDoorbellServiceBlockingStub(channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static VideoDoorbellServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    return new VideoDoorbellServiceFutureStub(channel);
  }

  /**
   */
  public static abstract class VideoDoorbellServiceImplBase implements io.grpc.BindableService {

    /**
     * <pre>
     *2nd
     * </pre>
     */
    public io.grpc.stub.StreamObserver<ds.adam.VideoDoorbell.Video> homeVideo(
        io.grpc.stub.StreamObserver<ds.adam.VideoDoorbell.BellRequest> responseObserver) {
      return asyncUnimplementedStreamingCall(getHomeVideoMethod(), responseObserver);
    }

    /**
     * <pre>
     *3rd
     * </pre>
     */
    public io.grpc.stub.StreamObserver<ds.adam.VideoDoorbell.DoorLockStatus> doorStatus(
        io.grpc.stub.StreamObserver<ds.adam.VideoDoorbell.DoorLockTamper> responseObserver) {
      return asyncUnimplementedStreamingCall(getDoorStatusMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getHomeVideoMethod(),
            asyncBidiStreamingCall(
              new MethodHandlers<
                ds.adam.VideoDoorbell.Video,
                ds.adam.VideoDoorbell.BellRequest>(
                  this, METHODID_HOME_VIDEO)))
          .addMethod(
            getDoorStatusMethod(),
            asyncClientStreamingCall(
              new MethodHandlers<
                ds.adam.VideoDoorbell.DoorLockStatus,
                ds.adam.VideoDoorbell.DoorLockTamper>(
                  this, METHODID_DOOR_STATUS)))
          .build();
    }
  }

  /**
   */
  public static final class VideoDoorbellServiceStub extends io.grpc.stub.AbstractStub<VideoDoorbellServiceStub> {
    private VideoDoorbellServiceStub(io.grpc.Channel channel) {
      super(channel);
    }

    private VideoDoorbellServiceStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected VideoDoorbellServiceStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new VideoDoorbellServiceStub(channel, callOptions);
    }

    /**
     * <pre>
     *2nd
     * </pre>
     */
    public io.grpc.stub.StreamObserver<ds.adam.VideoDoorbell.Video> homeVideo(
        io.grpc.stub.StreamObserver<ds.adam.VideoDoorbell.BellRequest> responseObserver) {
      return asyncBidiStreamingCall(
          getChannel().newCall(getHomeVideoMethod(), getCallOptions()), responseObserver);
    }

    /**
     * <pre>
     *3rd
     * </pre>
     */
    public io.grpc.stub.StreamObserver<ds.adam.VideoDoorbell.DoorLockStatus> doorStatus(
        io.grpc.stub.StreamObserver<ds.adam.VideoDoorbell.DoorLockTamper> responseObserver) {
      return asyncClientStreamingCall(
          getChannel().newCall(getDoorStatusMethod(), getCallOptions()), responseObserver);
    }
  }

  /**
   */
  public static final class VideoDoorbellServiceBlockingStub extends io.grpc.stub.AbstractStub<VideoDoorbellServiceBlockingStub> {
    private VideoDoorbellServiceBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private VideoDoorbellServiceBlockingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected VideoDoorbellServiceBlockingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new VideoDoorbellServiceBlockingStub(channel, callOptions);
    }
  }

  /**
   */
  public static final class VideoDoorbellServiceFutureStub extends io.grpc.stub.AbstractStub<VideoDoorbellServiceFutureStub> {
    private VideoDoorbellServiceFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private VideoDoorbellServiceFutureStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected VideoDoorbellServiceFutureStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new VideoDoorbellServiceFutureStub(channel, callOptions);
    }
  }

  private static final int METHODID_HOME_VIDEO = 0;
  private static final int METHODID_DOOR_STATUS = 1;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final VideoDoorbellServiceImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(VideoDoorbellServiceImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        default:
          throw new AssertionError();
      }
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public io.grpc.stub.StreamObserver<Req> invoke(
        io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_HOME_VIDEO:
          return (io.grpc.stub.StreamObserver<Req>) serviceImpl.homeVideo(
              (io.grpc.stub.StreamObserver<ds.adam.VideoDoorbell.BellRequest>) responseObserver);
        case METHODID_DOOR_STATUS:
          return (io.grpc.stub.StreamObserver<Req>) serviceImpl.doorStatus(
              (io.grpc.stub.StreamObserver<ds.adam.VideoDoorbell.DoorLockTamper>) responseObserver);
        default:
          throw new AssertionError();
      }
    }
  }

  private static abstract class VideoDoorbellServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    VideoDoorbellServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return ds.adam.VideoDoorbell.VideoDoorbellServiceImpl.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("VideoDoorbellService");
    }
  }

  private static final class VideoDoorbellServiceFileDescriptorSupplier
      extends VideoDoorbellServiceBaseDescriptorSupplier {
    VideoDoorbellServiceFileDescriptorSupplier() {}
  }

  private static final class VideoDoorbellServiceMethodDescriptorSupplier
      extends VideoDoorbellServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    VideoDoorbellServiceMethodDescriptorSupplier(String methodName) {
      this.methodName = methodName;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.MethodDescriptor getMethodDescriptor() {
      return getServiceDescriptor().findMethodByName(methodName);
    }
  }

  private static volatile io.grpc.ServiceDescriptor serviceDescriptor;

  public static io.grpc.ServiceDescriptor getServiceDescriptor() {
    io.grpc.ServiceDescriptor result = serviceDescriptor;
    if (result == null) {
      synchronized (VideoDoorbellServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new VideoDoorbellServiceFileDescriptorSupplier())
              .addMethod(getHomeVideoMethod())
              .addMethod(getDoorStatusMethod())
              .build();
        }
      }
    }
    return result;
  }
}
