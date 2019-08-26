package com.programing.locks;

public class MethodAThread extends Thread {

    private MyService service;

    public MethodAThread(MyService service, String threadName) {
        super();
        this.service = service;
        this.setName(threadName);
    }

    public void run() {
        service.methodA();
    }
}
