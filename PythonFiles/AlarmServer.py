import logging
import grpc
import Alarm_pb2
import Alarm_pb2_grpc
from google.protobuf.timestamp_pb2 import Timestamp
from zeroconf import ServiceBrowser, Zeroconf
from concurrent import futures
from zeroconf import ZeroconfServiceTypes


# class MyListener:
#
#     # Using zeroconf from https://pypi.org/project/zeroconf/ for registration and discovery
#     def remove_service(self, zeroconf, type, name):
#         print("The service %s has been removed" % (name,))
#
#     def add_service(self, zeroconf, type, name):
#         info = zeroconf.get_service_info(type, name)
#         print("The service %s has been added, service info is %s" % (name, info))
#
#
# zeroconf = Zeroconf()
# listener = MyListener()
# browser = ServiceBrowser(zeroconf, "_DublinSuburb22._tcp.local.", listener)


class Alarm(Alarm_pb2_grpc.AlarmServicer):

    def DoorLock(self, request, context):

        # soundSystem will always be the opposite value of isSecure. Going off that, we can use not request.isSecure to
        # make that value always the opposite. For the soundSystem, 1 would be true, and 0 would be false 
        timestamp = Timestamp()
        timestamp.GetCurrentTime()
        print(timestamp)

        return Alarm_pb2.Speaker(soundSystem=not request.isSecure, sirenTime=timestamp)


def serve():
    # try:
    #     input("To exit, press enter..\n\n")
    # finally:
    #     zeroconf.close()

    print('\n'.join(ZeroconfServiceTypes.find()))
    server = grpc.server(futures.ThreadPoolExecutor(max_workers=5))
    Alarm_pb2_grpc.add_AlarmServicer_to_server(Alarm(), server)
    server.add_insecure_port('[::]:50053')
    server.start()
    print('Server started on port 50053')
    server.wait_for_termination()


if __name__ == '__main__':
    MyListener()
    serve()
