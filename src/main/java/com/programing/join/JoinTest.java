package com.programing.join;

public class JoinTest {

    public static void main(String[] args) {
        TestThread testThread=new TestThread();
        testThread.start();
        try {
            //join 的作用是等待线程对象销毁
            //join 和 synchronized 的区别是join 在内部使用, synchronized 关键字使用的是对象监视器原理同步
            testThread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("thread end");

    }


}
class TestThread extends Thread{
    @Override
    public void run() {
        int secondValue=(int)(Math.random()*2000);
        System.out.println(secondValue);
        try {
            Thread.sleep(secondValue);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
