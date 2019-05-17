package com.headfirst.command;

public class RemoteControl {
    ICommand[] onCommands;
    ICommand[] offCommands;
    ICommand undoCommand;//记录前一个命令

    public RemoteControl() {
        onCommands = new ICommand[7];
        offCommands = new ICommand[7];
        ICommand noCommand = new NoCommand();

        undoCommand = noCommand;
        for (int i = 0; i < 7; i++) {
            onCommands[i] = noCommand;
            offCommands[i] = noCommand;
        }

    }

    public void setCommand(int slot, ICommand onCommand, ICommand offCommand) {
        onCommands[slot] = onCommand;
        offCommands[slot] = offCommand;
    }

    public void onButtonWasPushed(int slot) {
        onCommands[slot].execute();
        undoCommand = onCommands[slot];
    }

    public void offButtonWasPushed(int slot) {
        offCommands[slot].execute();
        undoCommand = offCommands[slot];
    }

    /**
     * 按下撤销按钮，撤销之前的操作
     */
    public void undoButtonWasPushed() {
        undoCommand.undo();
    }

}
