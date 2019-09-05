package com.programing.locks.faironfair;

import java.util.Random;
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
            Random random = new Random();
            Thread.sleep(random.nextInt(4)*1000);

            System.out.println("Thread Name=" + Thread.currentThread().getName() + " DO lock");
            lock.lock();
            Thread.sleep(4000);
            System.out.println("Thread Name=" + Thread.currentThread().getName() + " ##  获取锁");
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public static void main(String[] args) {
        final Service service = new Service(false);
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
