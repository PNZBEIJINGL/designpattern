package com.headfirst.command;

public class Stereo {
    public void on() {
        System.out.println("stereo.on");
    }


    public void setCD() {
        System.out.println("stereo.setCD");
    }

    public void setVolume(int i) {
        System.out.println("stereo.setVoleme:" + i);
    }

    public void off() {
        System.out.println("stereo.off");
    }
}
