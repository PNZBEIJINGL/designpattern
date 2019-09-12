package com.headfirst.singleton;

public class MyThread extends Thread {

    @Override
    public void run() {
        long time=System.currentTimeMillis();
        System.out.println(Thread.currentThread().getName() + " hashcode:" + MyObject.getInstance().hashCode());
        System.out.println(Thread.currentThread().getName() + " end time:"+(System.currentTimeMillis()-time));
    }
}
