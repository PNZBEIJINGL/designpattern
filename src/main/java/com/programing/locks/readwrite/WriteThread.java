package com.programing.locks.readwrite;

public class WriteThread extends Thread {

    private ReadWriteService service;

    public WriteThread(ReadWriteService service, String name) {
        super();
        this.setName(name);
        this.service = service;
    }

    @Override
    public void run() {
        service.write();
    }

}
