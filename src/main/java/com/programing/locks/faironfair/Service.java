package com.programing.locks.faironfair;

import java.util.concurrent.locks.ReentrantLock;

/**
 * 公平锁非公平锁测试
 */
public class Service {

    private ReentrantLock lock;

    /**
     * @param isFair 是否公平锁
     */
    public Service(boolean isFair) {
        super();
        lock = new ReentrantLock(isFair);
    }

    public void serviceMethod() {
        try {
            System.out.println("Thread Name=" + Thread.currentThread().getName() + " DO lock");
            lock.lock();
            System.out.println("Thread Name=" + Thread.currentThread().getName() + " ##  获取锁");
        } finally {
            lock.unlock();
        }
    }

    public static void main(String[] args) {
        final Service service = new Service(true);
        Runnable runable = new Runnable() {

            public void run() {
                System.out.println(Thread.currentThread().getName() + " 启动了");
                service.serviceMethod();
            }
        };
        Thread[] threads = new Thread[10];
        for (int i = 0; i < 10; i++) {
            threads[i] = new Thread(runable);
        }
        for (int i = 0; i < 10; i++) {
            threads[i].start();
        }
    }
}
