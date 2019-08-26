package com.programing.sleep;


public class SleepLockThreadA extends Thread {

    private SleepLockThreadB threadB;

    public SleepLockThreadA(SleepLockThreadB threadB) {
        super();
        this.threadB = threadB;
    }

    @Override
    public void run() {
        synchronized (threadB){
            threadB.start();
            try {
                Thread.sleep(6000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }
}
