package com.programing.access;

public class SynStaticThreadB extends Thread {

    public void run() {
        try {
            SynStaticService.printB();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
