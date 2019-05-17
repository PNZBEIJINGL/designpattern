package com.headfirst.command;

/**
 * 遥控器
 */
public class SimpleRemoteControl {
    ICommand slot;

    public SimpleRemoteControl() {

    }

    public void setSlot(ICommand command) {
        this.slot = command;
    }

    public void buttonWasPress() {
        slot.execute();
    }
}
