package com.programing.locks.faironfair;

import java.util.concurrent.locks.ReentrantLock;

public class TestIsFair {

    private ReentrantLock lock;

    public TestIsFair(boolean isFair) {
        super();
        lock = new ReentrantLock(isFair);
    }

    public void testFair() {
        try {
            lock.lock();
            System.out.println("是否公平锁：" + lock.isFair());
        } finally {
            lock.unlock();
        }
    }

    public static void main(String[] args) {
        //公平锁
        final TestIsFair test = new TestIsFair(true);
        Runnable runable = new Runnable() {
            public void run() {
                test.testFair();
            }
        };

        Thread thread = new Thread(runable);
        thread.start();

        //非公平锁,午参数构造器默认的时候是非公平锁
        final TestIsFair test2 = new TestIsFair(false);
        Runnable runable2 = new Runnable() {
            public void run() {
                test2.testFair();
            }
        };
        Thread thread2 = new Thread(runable2);
        thread2.start();
    }
}
