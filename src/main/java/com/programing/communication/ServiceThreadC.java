package com.programing.communication;

public class ServiceThreadC extends Thread {

    private Object lock;

    public ServiceThreadC(Object lock) {
        super();
        this.lock = lock;
    }

    public void run() {
        Service service=new Service();
        service.testMethod(lock);

    }

}
