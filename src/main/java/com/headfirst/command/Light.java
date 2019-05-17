package com.headfirst.command;

public class Light {

    private String room;

    public Light(String room) {
        this.room = room;
    }

    public void on() {

        System.out.println(room + " do Light On");
    }

    public void off() {
        System.out.println(room + " do Light Off");
    }
}
