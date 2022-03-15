import tkinter as tk
import tkinter.font as tkFont

class App:
    def __init__(self, root):
        #setting title
        root.title("undefined")
        #setting window size
        width=600
        height=500
        screenwidth = root.winfo_screenwidth()
        screenheight = root.winfo_screenheight()
        alignstr = '%dx%d+%d+%d' % (width, height, (screenwidth - width) / 2, (screenheight - height) / 2)
        root.geometry(alignstr)
        root.resizable(width=False, height=False)

        GLineEdit_520=tk.Entry(root)
        GLineEdit_520["borderwidth"] = "1px"
        ft = tkFont.Font(family='Times',size=10)
        GLineEdit_520["font"] = ft
        GLineEdit_520["fg"] = "#333333"
        GLineEdit_520["justify"] = "center"
        GLineEdit_520["text"] = "Entry"
        GLineEdit_520.place(x=70,y=60,width=70,height=25)

        GLineEdit_477=tk.Entry(root)
        GLineEdit_477["borderwidth"] = "1px"
        ft = tkFont.Font(family='Times',size=10)
        GLineEdit_477["font"] = ft
        GLineEdit_477["fg"] = "#333333"
        GLineEdit_477["justify"] = "center"
        GLineEdit_477["text"] = "Entry"
        GLineEdit_477.place(x=70,y=140,width=70,height=25)

        GLineEdit_204=tk.Entry(root)
        GLineEdit_204["borderwidth"] = "1px"
        ft = tkFont.Font(family='Times',size=10)
        GLineEdit_204["font"] = ft
        GLineEdit_204["fg"] = "#333333"
        GLineEdit_204["justify"] = "center"
        GLineEdit_204["text"] = "Entry"
        GLineEdit_204.place(x=70,y=220,width=70,height=25)

        GButton_927=tk.Button(root)
        GButton_927["bg"] = "#efefef"
        ft = tkFont.Font(family='Times',size=10)
        GButton_927["font"] = ft
        GButton_927["fg"] = "#000000"
        GButton_927["justify"] = "center"
        GButton_927["text"] = "Button"
        GButton_927.place(x=330,y=60,width=70,height=25)
        GButton_927["command"] = self.GButton_927_command

        GButton_629=tk.Button(root)
        GButton_629["bg"] = "#efefef"
        ft = tkFont.Font(family='Times',size=10)
        GButton_629["font"] = ft
        GButton_629["fg"] = "#000000"
        GButton_629["justify"] = "center"
        GButton_629["text"] = "Button"
        GButton_629.place(x=330,y=140,width=70,height=25)
        GButton_629["command"] = self.GButton_629_command

        GButton_700=tk.Button(root)
        GButton_700["bg"] = "#efefef"
        ft = tkFont.Font(family='Times',size=10)
        GButton_700["font"] = ft
        GButton_700["fg"] = "#000000"
        GButton_700["justify"] = "center"
        GButton_700["text"] = "Button"
        GButton_700.place(x=330,y=230,width=70,height=25)
        GButton_700["command"] = self.GButton_700_command

    def GButton_927_command(self):
        print("command")


    def GButton_629_command(self):
        print("command")


    def GButton_700_command(self):
        print("command")

if __name__ == "__main__":
    root = tk.Tk()
    app = App(root)
    root.mainloop()
