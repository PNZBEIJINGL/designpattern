package com.headfirst.singleton;

public class MyObject {

    private volatile static MyObject myObject;

    private MyObject() {

    }

    /**
     * 提升效率使用DCL 双检查锁机制
     * 保证不需要同步代码的异步性和单例的效果
     *
     * @return
     */
    public static MyObject getInstance() {
        try {
            if (myObject == null) {
                Thread.sleep(3000);//模拟INIT准备工作
                synchronized (MyObject.class) {
                    if (myObject == null) {
                        myObject = new MyObject();
                    }
                }
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        return myObject;
    }

    public static void main(String[] args) {
        MyThread t1 = new MyThread();
        t1.setName("T1");
        MyThread t2 = new MyThread();
        t2.setName("T2");
        MyThread t3 = new MyThread();
        t3.setName("T3");

        t1.start();
        t2.start();
        t3.start();
    }

}
