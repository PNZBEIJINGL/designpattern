package com.programing.locks;

public class ConditionTestThreadB extends Thread {

    private ConditionTestService testService;

    public ConditionTestThreadB(ConditionTestService testService) {
        this.testService = testService;
    }

    public void run() {

        testService.await2();
    }

}
