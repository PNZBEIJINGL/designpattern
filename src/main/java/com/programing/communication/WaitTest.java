package com.programing.communication;

public class WaitTest {

    static private Object lock = new Object();

    static private Runnable runable = new Runnable() {

        public void run() {
            synchronized (lock) {
                System.out.println(Thread.currentThread().getName() + "|" + System.currentTimeMillis());
                try {
                    lock.wait(5000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName() + "|" + System.currentTimeMillis());
            }
        }
    };

    static private Runnable runable2 = new Runnable() {
        public void run() {
            synchronized (lock) {
                System.out.println(Thread.currentThread().getName() + "|" + System.currentTimeMillis());
                lock.notify();
                System.out.println(Thread.currentThread().getName() + "|" + System.currentTimeMillis());
            }
        }
    };


    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(runable);
        thread.start();

        Thread.sleep(3000);
        Thread thread2 = new Thread(runable2);
        thread2.start();
    }

}
