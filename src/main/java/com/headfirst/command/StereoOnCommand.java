package com.headfirst.command;

public class StereoOnCommand implements ICommand {
    private Stereo stereo;

    public StereoOnCommand(Stereo stereo){
        this.stereo=stereo;
    }

    public void execute() {
        stereo.on();
        stereo.setCD();
        stereo.setVolume(11);
    }

    public void undo() {
        stereo.off();
    }
}
