package com.headfirst.command;

public class RemoteLoad {


    public static void main(String[] args) {
        RemoteControl remoteControl = new RemoteControl();

        Light livingRoomLight = new Light("Living Room");
        LightOnCommand livingroomLightOn = new LightOnCommand(livingRoomLight);
        LightOffCommand livngroomLightOff = new LightOffCommand(livingRoomLight);


        remoteControl.setCommand(0, livingroomLightOn, livngroomLightOff);

        remoteControl.onButtonWasPushed(0);
        remoteControl.offButtonWasPushed(0);
        remoteControl.undoButtonWasPushed();
    }
}
