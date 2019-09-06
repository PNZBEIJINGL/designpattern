package com.programing.locks.readwrite;

import java.util.concurrent.locks.ReentrantReadWriteLock;

public class ReadWriteService {

    private ReentrantReadWriteLock readWriteLock = new ReentrantReadWriteLock();

    public void read() {
        try {
            readWriteLock.readLock().lock();
            System.out.println("Get read lock " + Thread.currentThread().getName() + " " + System.currentTimeMillis());
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            readWriteLock.readLock().unlock();
        }
    }

    public void write() {
        try {
            readWriteLock.writeLock().lock();
            System.out.println("Get write lock " + Thread.currentThread().getName() + " " + System.currentTimeMillis());
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            readWriteLock.writeLock().unlock();
        }
    }

}
