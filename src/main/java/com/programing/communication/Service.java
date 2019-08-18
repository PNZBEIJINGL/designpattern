package com.programing.communication;

public class Service {

    public void testMethod(Object lock){
        synchronized (lock){
            System.out.println(Thread.currentThread().getName()+" start");
            try {
                lock.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName()+" continue");
            System.out.println(Thread.currentThread().getName()+" end");
        }
    }

}
