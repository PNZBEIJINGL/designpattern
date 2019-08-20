package com.programing.sleep;


public class SleepLockThreadC extends Thread {

    private SleepLockThreadB threadB;

    public SleepLockThreadC(SleepLockThreadB threadB) {
        super();
        this.threadB = threadB;
    }

    @Override
    public void run() {
        threadB.doservice();
    }
}
