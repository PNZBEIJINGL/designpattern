package com.programing.communication;

public class ServiceThreadA extends Thread {

    private Object lock;

    public ServiceThreadA(Object lock) {
        super();
        this.lock = lock;
    }

    public void run() {
        Service service=new Service();
        service.testMethod(lock);

    }

}
