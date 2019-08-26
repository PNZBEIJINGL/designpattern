package com.programing.locks;

public class MethodBThread extends Thread {

    private MyService service;

    public MethodBThread(MyService service, String threadName) {
        super();
        this.service = service;
        this.setName(threadName);
    }

    public void run() {
        service.methodB();
    }
}
