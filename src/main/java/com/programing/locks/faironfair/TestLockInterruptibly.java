package com.programing.locks.faironfair;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class TestLockInterruptibly {

    private ReentrantLock lock = new ReentrantLock();
    private Condition condition = lock.newCondition();

    public void waitMethod() {
        try {
            lock.lock();
            System.out.println(Thread.currentThread().getName() + " in waitMethod");
            for (int i = 0; i < Integer.MAX_VALUE / 10; i++) {
                Math.random();
            }
            System.out.println(Thread.currentThread().getName() + " end waitMethod");
        } finally {
            //如果当前线程没有被中断，则获取锁
            if (lock.isHeldByCurrentThread()) {
                lock.unlock();
                System.out.println(Thread.currentThread().getName() + " lock.unlock");
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        final TestLockInterruptibly test = new TestLockInterruptibly();
        Runnable runnable = new Runnable() {
            public void run() {
                test.waitMethod();
            }
        };

        Thread threada = new Thread(runnable);
        threada.setName("A");
        Thread threadb = new Thread(runnable);
        threadb.setName("B");

        threada.start();
        Thread.sleep(500);
        threadb.start();
        threadb.interrupt();
        System.out.println("main end");
    }

}
