package com.programing.locks;

public class ConditionTest {

    public static void main(String[] args) throws InterruptedException {

        //测试1 conditon 唤醒
        ConditionTestService service = new ConditionTestService();
        ConditionTestThread testThread = new ConditionTestThread(service);
        testThread.start();
        Thread.sleep(3000);
        service.signal();

        //测试2 唤醒多个线程，运行后2个线程都被唤醒
        ConditionTestService service2 = new ConditionTestService();
        ConditionTestThread testThread2 = new ConditionTestThread(service);
        testThread2.start();

        ConditionTestThreadB testThreadB=new ConditionTestThreadB(service2);
        testThreadB.start();

        Thread.sleep(3000);
        service.signalAll();

    }
}
