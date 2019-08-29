package com.programing.locks;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ConditionTestService {

    private Lock lock = new ReentrantLock();
    private Condition condition = lock.newCondition();

    public void await() {
        try {
            lock.lock();
            System.out.println(Thread.currentThread().getName() + " before await" + System.currentTimeMillis());
            condition.await();
            System.out.println(Thread.currentThread().getName() + " after await" + System.currentTimeMillis());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public void signal() {
        lock.lock();
        System.out.println(Thread.currentThread().getName() + " before signal" + System.currentTimeMillis());
        condition.signal();
        System.out.println(Thread.currentThread().getName() + " after signal" + System.currentTimeMillis());
        lock.unlock();
    }

    public void await2() {
        try {
            lock.lock();
            System.out.println(Thread.currentThread().getName() + " before awaitb" + System.currentTimeMillis());
            condition.await();
            System.out.println(Thread.currentThread().getName() + " after awaitb" + System.currentTimeMillis());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }


    public void signalAll() {
        lock.lock();
        System.out.println(Thread.currentThread().getName() + " before signal all" + System.currentTimeMillis());
        condition.signalAll();
        System.out.println(Thread.currentThread().getName() + " after signal all" + System.currentTimeMillis());
        lock.unlock();
    }


}
