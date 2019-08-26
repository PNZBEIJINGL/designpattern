package com.programing.threadlocal;

public class DivideTest {

    public static void main(String[] args) throws InterruptedException {
        //验证线程变量的隔离行
        DivideThreadA threadA = new DivideThreadA();
        threadA.start();
        Thread.sleep(1000);
        DivideThreadB threadB = new DivideThreadB();
        threadB.start();
    }

}
