package com.programing.communication;

public class ServiceThreadB extends Thread {

    private Object lock;

    public ServiceThreadB(Object lock) {
        super();
        this.lock = lock;
    }

    public void run() {
        Service service=new Service();
        service.testMethod(lock);

    }

}
