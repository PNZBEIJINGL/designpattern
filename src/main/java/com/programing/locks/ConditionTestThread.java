package com.programing.locks;

public class ConditionTestThread extends Thread {

    private ConditionTestService testService;

    public ConditionTestThread(ConditionTestService testService) {
        this.testService = testService;
    }

    public void run() {

        testService.await();
    }

}
