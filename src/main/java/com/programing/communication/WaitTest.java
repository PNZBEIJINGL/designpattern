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

    public static void main(String[] args) {
        Thread thread=new Thread(runable);
        thread.start();
    }

}
