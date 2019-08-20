package com.programing.sleep;

public class SleepLockThreadB extends Thread {

    @Override
    public void run() {
        System.out.println("ThreadB is running");
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("ThreadB is end");
    }

    synchronized  public void doservice(){
        System.out.println("in doservice");
    }

}
