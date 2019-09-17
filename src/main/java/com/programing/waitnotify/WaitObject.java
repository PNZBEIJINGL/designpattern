package com.programing.waitnotify;

public class WaitObject extends Thread {

    @Override
    public void run() {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("after wait");
    }

}
