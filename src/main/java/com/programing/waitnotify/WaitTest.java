package com.programing.waitnotify;

/**
 * wait测试
 */
public class WaitTest {

    public static void main(String[] args) throws InterruptedException {
        System.out.println("start");
        WaitObject object = new WaitObject();
        object.start();
        Thread.sleep(5000);
        System.out.println("end");

    }
}
