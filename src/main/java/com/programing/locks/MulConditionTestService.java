package com.programing.locks;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class MulConditionTestService {

    private Lock lock = new ReentrantLock();
    private Condition condition1 = lock.newCondition();
    private Condition condition2 = lock.newCondition();

    public void awaitMethod1() {
        try {
            lock.lock();
            System.out.println(Thread.currentThread().getName() + " before await1" + System.currentTimeMillis());
            condition1.await();
            System.out.println(Thread.currentThread().getName() + " after await1" + System.currentTimeMillis());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public void awaitMethod2() {
        try {
            lock.lock();
            System.out.println(Thread.currentThread().getName() + " before await2" + System.currentTimeMillis());
            condition1.await();
            System.out.println(Thread.currentThread().getName() + " after await2" + System.currentTimeMillis());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public void signalConditon1() {
        lock.lock();
        System.out.println(Thread.currentThread().getName() + " before signalMethod1 " + System.currentTimeMillis());
        condition1.signalAll();
        System.out.println(Thread.currentThread().getName() + " after signalMethod1 " + System.currentTimeMillis());
        lock.unlock();
    }

    public void signalCodition2() {
        lock.lock();
        System.out.println(Thread.currentThread().getName() + " before signalMethod2 " + System.currentTimeMillis());
        condition2.signalAll();
        System.out.println(Thread.currentThread().getName() + " after signalMethod2 " + System.currentTimeMillis());
        lock.unlock();
    }

}
