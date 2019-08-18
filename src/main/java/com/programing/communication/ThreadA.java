package com.programing.communication;

public class ThreadA extends Thread {

    private Object lock;
    public ThreadA(Object lock){
        super();
        this.lock=lock;
    }

    public void run(){
        synchronized (lock){
            if(MyList.size()!=5){
                System.out.println("do waiting");
                try {
                    lock.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                ;
                System.out.println("end waiting");
            }
        }
    }
}
