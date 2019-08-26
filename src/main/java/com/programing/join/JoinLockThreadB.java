package com.programing.join;

public class JoinLockThreadB extends Thread {

    @Override
    synchronized  public void run() {
        System.out.println("JoinLockThread b start");
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("JoinLockThread b end");
    }
}
