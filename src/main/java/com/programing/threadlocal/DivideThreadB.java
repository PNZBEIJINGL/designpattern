package com.programing.threadlocal;

public class DivideThreadB extends Thread {

    public void run() {
        for (int i = 0; i < 10; i++) {
            Tools.t1.set(Thread.currentThread().getName() + " " + i);
            System.out.println(Tools.t1.get());

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
