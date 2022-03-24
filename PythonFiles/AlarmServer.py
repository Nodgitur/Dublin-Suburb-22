from concurrent import futures
import logging
import grpc
from google.protobuf.timestamp_pb2 import Timestamp

from datetime import datetime
import Alarm_pb2
import Alarm_pb2_grpc


class Alarm(Alarm_pb2_grpc.AlarmServicer):

    def DoorLock(self, request, context):

        # soundSystem will always be the opposite value of isSecure. Going off that, we can use not request.isSecure to
        # make that value always the opposite. For the soundSystem, 1 would be true, and 0 would be false 
        timestamp = Timestamp()
        timestamp.GetCurrentTime()
        print(timestamp)

        return Alarm_pb2.Speaker(soundSystem=not request.isSecure, sirenTime=timestamp)


def serve():
    server = grpc.server(futures.ThreadPoolExecutor(max_workers=5))
    Alarm_pb2_grpc.add_AlarmServicer_to_server(Alarm(), server)
    server.add_insecure_port('[::]:50053')
    server.start()
    print('Server started on port 50053')
    server.wait_for_termination()


if __name__ == '__main__':
    serve()