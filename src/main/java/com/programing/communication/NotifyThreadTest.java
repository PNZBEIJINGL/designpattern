package com.programing.communication;

/**
 * notify 和 notifyAll
 */
public class NotifyThreadTest extends Thread {
    private Object lock;

    public NotifyThreadTest(Object lock) {
        super();
        this.lock = lock;
    }

    public void run() {
        synchronized (lock) {
            //notify一次唤醒阻塞队列中的一个线程
            /*
            lock.notify();
            lock.notify();
            lock.notify();
            lock.notify();
            */


            //notifyAll 唤醒阻塞队列中的所有线程
            lock.notifyAll();
        }
    }

    public static void main(String[] args) {
        Object lock = new Object();
        ServiceThreadA threadA = new ServiceThreadA(lock);
        threadA.start();
        ServiceThreadB threadB = new ServiceThreadB(lock);
        threadB.start();
        ServiceThreadC threadC = new ServiceThreadC(lock);
        threadC.start();

        NotifyThreadTest test = new NotifyThreadTest(lock);
        test.start();

    }

}
