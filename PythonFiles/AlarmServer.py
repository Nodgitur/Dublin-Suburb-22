import logging
import socket
import grpc
import Alarm_pb2
import Alarm_pb2_grpc
from google.protobuf.timestamp_pb2 import Timestamp
from concurrent import futures
from zeroconf import ZeroconfServiceTypes, Zeroconf, ServiceInfo

def serviceRegistration():
    zf = Zeroconf()
    ip = socket.gethostbyname(socket.gethostname())
    #Service Registration
    try:
        service_type = "_DublinSuburb22._tcp.local."
        service_name = "alarm._DublinSuburb22._tcp.local."
        service_port = 50053
        desc = {}
        print("Alarm service properties...")
        print("\t service_type:" + service_type)
        print("\t service_name:" + service_name)
        print("\t service_description:" + str(desc))
        print("\t service_port: " + str(service_port))
        info = ServiceInfo(
            type_=service_type,
            name=service_name,
            port=service_port,
            properties=desc,
            parsed_addresses=[ip]
            )
        print("Registration attempt with the service type " + service_type + " and name " + service_name)
        zf.register_service(info)
    finally:
        print("Finished registration")

class Alarm(Alarm_pb2_grpc.AlarmServicer):

    #Registering service
    serviceRegistration()

    def DoorLock(self, request, context):

        # soundSystem will always be the opposite value of isSecure. Going off that, we can use not request.isSecure to
        # make that value always the opposite. For the soundSystem, 1 would be true, and 0 would be false 
        timestamp = Timestamp()
        timestamp.GetCurrentTime()
        print(timestamp)

        return Alarm_pb2.Speaker(soundSystem=not request.isSecure, sirenTime=timestamp)


def serve():
    print('\n'.join(ZeroconfServiceTypes.find()))
    server = grpc.server(futures.ThreadPoolExecutor(max_workers=5))
    Alarm_pb2_grpc.add_AlarmServicer_to_server(Alarm(), server)
    server.add_insecure_port('[::]:50053')
    server.start()
    print('Server started on port 50053')
    server.wait_for_termination()


if __name__ == '__main__':
    logging.basicConfig()
    serve()
