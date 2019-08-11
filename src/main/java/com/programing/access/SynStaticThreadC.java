package com.programing.access;

public class SynStaticThreadC extends Thread {

    private SynStaticService service;

    public SynStaticThreadC(SynStaticService service) {
        super();
        this.service = service;
    }

    public void run() {
        service.printC();
    }
}
