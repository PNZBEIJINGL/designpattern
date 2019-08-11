package com.programing.access;

public class SynStaticThreadA extends Thread {

    private SynStaticService service;

    @Override
    public void run() {

        try {
            SynStaticService.printA();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
