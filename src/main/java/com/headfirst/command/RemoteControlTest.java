package com.headfirst.command;

public class RemoteControlTest {
    public static void main(String[] args) {
        SimpleRemoteControl control=new SimpleRemoteControl();
        Light light=new Light("Living room");
        LightOnCommand command=new LightOnCommand(light);

        control.setSlot(command);
        control.buttonWasPress();
    }
}
