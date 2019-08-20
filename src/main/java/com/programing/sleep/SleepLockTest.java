package com.programing.sleep;

public class SleepLockTest {

    public static void main(String[] args) throws InterruptedException {
        SleepLockThreadB threadB = new SleepLockThreadB();
        SleepLockThreadA threadA = new SleepLockThreadA(threadB);
        threadA.start();
        SleepLockThreadA.sleep(1000);

        SleepLockThreadC threadC = new SleepLockThreadC(threadB);
        threadC.start();  //wait thread b lock

    }
}
