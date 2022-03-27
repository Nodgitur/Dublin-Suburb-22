import Alarm_pb2
import Alarm_pb2_grpc
import grpc

import SmartphoneSecurityApplication_pb2
import SmartphoneSecurityApplication_pb2_grpc
import VideoDoorbell_pb2
import VideoDoorbell_pb2_grpc

import tkinter as tk
import tkinter.font as tkFont

class App:
    def __init__(self, root):

        global door_status_stream
        global home_video_stream
        global home_video_checkbox_status
        global door_status_checkbox_status
        global door_lock_checkbox_status
        global alarm_check
        door_status_stream = []
        home_video_stream = []
        home_video_checkbox_status = tk.IntVar()
        door_status_checkbox_status = tk.IntVar()
        door_lock_checkbox_status = tk.IntVar()
        alarm_check = False

        # setting title
        root.title("Dublin Suburb 22")
        # setting window size
        width = 600
        height = 600
        screenwidth = root.winfo_screenwidth()
        screenheight = root.winfo_screenheight()
        alignstr = '%dx%d+%d+%d' % (width, height, (screenwidth - width) / 2, (screenheight - height) / 2)
        root.geometry(alignstr)
        root.resizable(width=False, height=False)

        # Home Video Submit Button
        GButton_762 = tk.Button(root)
        GButton_762["bg"] = "#efefef"
        ft = tkFont.Font(family='Times', size=10)
        GButton_762["font"] = ft
        GButton_762["fg"] = "#000000"
        GButton_762["justify"] = "center"
        GButton_762["text"] = "Send Stream"
        GButton_762.place(x=180, y=40, width=70, height=25)
        GButton_762["command"] = self.GButton_762_command

        # Home Video Push Stream Button
        GButton_118 = tk.Button(root)
        GButton_118["bg"] = "#efefef"
        ft = tkFont.Font(family='Times', size=10)
        GButton_118["font"] = ft
        GButton_118["fg"] = "#000000"
        GButton_118["justify"] = "center"
        GButton_118["text"] = "Add Stream"
        GButton_118.place(x=180, y=80, width=70, height=25)
        GButton_118["command"] = self.GButton_118_command

        GMessage_8 = tk.Message(root)
        ft = tkFont.Font(family='Times', size=10)
        GMessage_8["font"] = ft
        GMessage_8["fg"] = "#333333"
        GMessage_8["justify"] = "center"
        GMessage_8["text"] = "Doorbell Video"
        GMessage_8.place(x=40, y=40, width=107, height=30)

        GMessage_319 = tk.Message(root)
        ft = tkFont.Font(family='Times', size=10)
        GMessage_319["font"] = ft
        GMessage_319["fg"] = "#333333"
        GMessage_319["justify"] = "center"
        GMessage_319["text"] = "Door Unlock"
        GMessage_319.place(x=20, y=300, width=143, height=38)

        GMessage_658 = tk.Message(root)
        ft = tkFont.Font(family='Times', size=10)
        GMessage_658["font"] = ft
        GMessage_658["fg"] = "#333333"
        GMessage_658["justify"] = "center"
        GMessage_658["text"] = "Lock Alarm"
        GMessage_658.place(x=30, y=440, width=133, height=49)

        # Home video checkbox
        global GCheckbox_791
        GCheckBox_791 = tk.Checkbutton(root, variable=home_video_checkbox_status)
        ft = tkFont.Font(family='Times', size=10)
        GCheckBox_791["font"] = ft
        GCheckBox_791["fg"] = "#333333"
        GCheckBox_791["justify"] = "center"
        GCheckBox_791["text"] = "True"
        GCheckBox_791.place(x=280, y=40, width=70, height=25)
        GCheckBox_791["offvalue"] = "0"
        GCheckBox_791["onvalue"] = "1"
        GCheckBox_791["command"] = self.GCheckBox_791_command

        # Door Status checkbox
        global GCheckbox_393
        GCheckBox_393 = tk.Checkbutton(root, variable=door_status_checkbox_status)
        ft = tkFont.Font(family='Times', size=10)
        GCheckBox_393["font"] = ft
        GCheckBox_393["fg"] = "#333333"
        GCheckBox_393["justify"] = "center"
        GCheckBox_393["text"] = "True"
        GCheckBox_393.place(x=280, y=170, width=70, height=25)
        GCheckBox_393["offvalue"] = "0"
        GCheckBox_393["onvalue"] = "1"
        GCheckBox_393["command"] = self.GCheckBox_393_command

        # Alarm checkbox
        global GCheckbox_484
        GCheckBox_484 = tk.Checkbutton(root, variable=door_lock_checkbox_status)
        ft = tkFont.Font(family='Times', size=10)
        GCheckBox_484["font"] = ft
        GCheckBox_484["fg"] = "#333333"
        GCheckBox_484["justify"] = "center"
        GCheckBox_484["text"] = "True"
        GCheckBox_484.place(x=280, y=450, width=70, height=25)
        GCheckBox_484["offvalue"] = "0"
        GCheckBox_484["onvalue"] = "1"
        GCheckBox_484["command"] = self.GCheckBox_484_command

        # Door unlock submit button
        global GButton_319
        GButton_319 = tk.Button(root)
        GButton_319["bg"] = "#efefef"
        ft = tkFont.Font(family='Times', size=10)
        GButton_319["font"] = ft
        GButton_319["fg"] = "#000000"
        GButton_319["justify"] = "center"
        GButton_319["text"] = "Send Stream"
        GButton_319.place(x=180, y=300, width=70, height=25)
        GButton_319["command"] = self.GButton_319_command

        # Alarm submit button
        global GButton_286
        GButton_286 = tk.Button(root)
        GButton_286["bg"] = "#efefef"
        ft = tkFont.Font(family='Times', size=10)
        GButton_286["font"] = ft
        GButton_286["fg"] = "#000000"
        GButton_286["justify"] = "center"
        GButton_286["text"] = "Send Stream"
        GButton_286.place(x=180, y=450, width=70, height=25)
        GButton_286["command"] = self.GButton_286_command

        global GLineEdit_204
        GLineEdit_204 = tk.Entry(root)
        GLineEdit_204["borderwidth"] = "1px"
        ft = tkFont.Font(family='Times', size=10)
        GLineEdit_204["font"] = ft
        GLineEdit_204["fg"] = "#333333"
        GLineEdit_204.place(x=280, y=300, width=80, height=40)

        global GMessage_716
        GMessage_716 = tk.Text(root)
        ft = tkFont.Font(family='Times', size=10)
        GMessage_716["font"] = ft
        GMessage_716["fg"] = "#333333"
        GMessage_716.place(x=450, y=480, width=120, height=70)

        global GMessage_704
        GMessage_704 = tk.Text(root)
        ft = tkFont.Font(family='Times', size=10)
        GMessage_704["font"] = ft
        GMessage_704["fg"] = "#333333"
        GMessage_704.place(x=450, y=330, width=108, height=40)

        global GMessage_381
        GMessage_381 = tk.Text(root)
        ft = tkFont.Font(family='Times', size=10)
        GMessage_381["font"] = ft
        GMessage_381["fg"] = "#333333"
        GMessage_381.place(x=450, y=60, width=130, height=80)

        GMessage_13 = tk.Message(root)
        ft = tkFont.Font(family='Times', size=10)
        GMessage_13["font"] = ft
        GMessage_13["fg"] = "#333333"
        GMessage_13["justify"] = "center"
        GMessage_13["text"] = "Door Status"
        GMessage_13.place(x=50, y=170, width=80, height=25)

        # Door Status Submitted
        GButton_885 = tk.Button(root)
        GButton_885["bg"] = "#efefef"
        ft = tkFont.Font(family='Times', size=10)
        GButton_885["font"] = ft
        GButton_885["fg"] = "#000000"
        GButton_885["justify"] = "center"
        GButton_885["text"] = "Send Stream"
        GButton_885.place(x=180, y=170, width=70, height=25)
        GButton_885["command"] = self.GButton_885_command

        # Door Status Stream Button
        GButton_732 = tk.Button(root)
        GButton_732["bg"] = "#efefef"
        ft = tkFont.Font(family='Times', size=10)
        GButton_732["font"] = ft
        GButton_732["fg"] = "#000000"
        GButton_732["justify"] = "center"
        GButton_732["text"] = "Add Stream"
        GButton_732.place(x=180, y=220, width=70, height=25)
        GButton_732["command"] = self.GButton_732_command

        global GMessage_490
        GMessage_490 = tk.Text(root)
        ft = tkFont.Font(family='Times', size=10)
        GMessage_490["font"] = ft
        GMessage_490["fg"] = "#333333"
        GMessage_490.place(x=450, y=200, width=100, height=50)

    # Home video send stream
    def GButton_762_command(self):
        print("Home Video Submitted")
        self.home_video_send_request()

    # Home video add stream
    def GButton_118_command(self):
        print("Home Video Stream")
        home_video_stream.append(bool(home_video_checkbox_status.get()))

    # Door status send stream
    def GButton_319_command(self):
        print("Door Status Submitted")
        self.visitor_unlock_send_request()

    # Door status add stream
    def GButton_732_command(self):
        print("Door Status Stream")
        door_status_stream.append(bool(door_status_checkbox_status.get()))

    # Door unlock send stream
    def GButton_286_command(self):
        print("Door Unlock Submitted")
        self.door_lock_send_request()

    # Door status send stream
    def GButton_885_command(self):
        print("Door Status Submitted")
        self.door_status_send_request()

    # Home video checkbox
    def GCheckBox_791_command(self):
        home_video_checkbox_status.get()

    # Door Status checkbox
    def GCheckBox_393_command(self):
        global ds_check
        ds_check = bool(door_status_checkbox_status.get())

    # Alarm checkbox
    def GCheckBox_484_command(self):
        print("Alarm check")

    # Server side streaming
    def visitor_unlock_send_request(self):
        channel = grpc.insecure_channel('localhost: 50052')
        stub = SmartphoneSecurityApplication_pb2_grpc.SmartphoneSecurityApplicationServiceStub(channel)

        GMessage_704.config(state="normal")
        GMessage_704.delete("1.0", "end")

        # Use of tuples to accept two numbers into both of the variables
        try:
            (code1,code2) = GLineEdit_204.get().split(",")
        except ValueError:
            print("Invalid type, should be a number")
            return

        request = SmartphoneSecurityApplication_pb2.DoorRequest(
                visitorRequestCode1=int(code1),
                visitorRequestCode2=int(code2))

        for response in stub.visitorUnlock(request):
            GMessage_704.insert("1.0", response)

    # Client side streaming
    def door_status_send_request(self):
        channel = grpc.insecure_channel('localhost: 50051')
        stub = VideoDoorbell_pb2_grpc.VideoDoorbellServiceStub(channel)

        GMessage_490.delete("1.0", "end")
        response = stub.doorStatus(door_status_request_iterator())
        if response.intruder == 1:
            door_status_response_message = "Intruder!"
        else:
            door_status_response_message = "No intruders!"
        print(response)
        GMessage_490.insert("1.0", door_status_response_message)
        door_status_stream.clear()

    # Unary streaming
    def door_lock_send_request(self):
        channel = grpc.insecure_channel('localhost: 50053')
        stub = Alarm_pb2_grpc.AlarmStub(channel)

        print(door_lock_checkbox_status.get())

        response = stub.DoorLock(Alarm_pb2.UnwantedVisitor(isSecure=door_lock_checkbox_status.get() == 1))

        GMessage_716.config(state="normal")
        GMessage_716.delete("1.0", "end")
        GMessage_716.insert("1.0", response)

    # Bidirectional streaming
    def home_video_send_request(self):
        channel = grpc.insecure_channel('localhost: 50051')

        stub = VideoDoorbell_pb2_grpc.VideoDoorbellServiceStub(channel=channel)

        GMessage_381.config(state="normal")
        GMessage_381.delete("1.0", "end")

        # Iterating through response
        for response in stub.homeVideo(home_video_request_iterator()):
            if response.visual == 1:
                response_message = "CONNECTED \n"
            else:
                response_message = "DISCONNECTED \n"
            response_message = response_message + str("Requests made: " + str(response.connectionIntervals)) + "\n"
            print(response)
            GMessage_381.insert("1.0", response_message)
        home_video_stream.clear()

# Iterator for client requests
def door_status_request_iterator():
    try:
        for stream in door_status_stream:
            request = VideoDoorbell_pb2.DoorLockStatus(check=stream)
            yield request
    except Exception as e:
        GMessage_490.config(state="normal")
        GMessage_490.delete("1.0", "end")
        GMessage_490.insert("1.0", e)


# Iterator for home video client requests
def home_video_request_iterator():
    try:
        for stream in home_video_stream:
            request = VideoDoorbell_pb2.Video(videoConfimrationFromBell=stream)
            yield request
    except Exception as e:
        print("Caught exception")
        print(e)
        GMessage_381.config(state="normal")
        GMessage_381.delete("1.0", "end")
        GMessage_381.insert("1.0", "end")

if __name__ == "__main__":
    root = tk.Tk()
    app = App(root)
    root.mainloop()
