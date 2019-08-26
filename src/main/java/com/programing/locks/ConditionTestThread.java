package com.programing.locks;

public class ConditionTestThread extends Thread {

    private ConditionTestService testService;

    public ConditionTestThread(ConditionTestService testService) {
        this.testService = testService;
    }

    public void run() {
        testService.await();
    }

    public static void main(String[] args) throws InterruptedException {


        ConditionTestService service = new ConditionTestService();
        ConditionTestThread testThread = new ConditionTestThread(service);
        testThread.start();

        Thread.sleep(3000);
        service.signal();
    }
}
