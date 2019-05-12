package com.thread.worker;

import java.util.Random;

/**
 * 工作请求
 */
public class Request {

    private final String name;//委托者名字
    private final int number;//请求编号
    private static final Random random = new Random();

    public Request(String name, int number) {
        this.name = name;
        this.number = number;
    }

    public void execute() {
        System.out.println(Thread.currentThread().getName() + " do executes:" + this);

        try {
            Thread.sleep(random.nextInt(1000));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public String toString() {
        return "[ Request from " + name + " No. " + number + "]";
    }

}
