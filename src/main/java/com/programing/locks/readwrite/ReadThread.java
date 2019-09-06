package com.programing.locks.readwrite;

public class ReadThread extends Thread {

    private ReadWriteService service;

    public ReadThread(ReadWriteService service, String name) {
        super();
        this.setName(name);
        this.service = service;
    }

    @Override
    public void run() {
        service.read();
    }
}
