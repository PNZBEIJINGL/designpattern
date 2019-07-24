package com.programing.stop;

public class DaemonTest {

    public static void main(String[] args) {
        //守护线程，进程中存在非守护线程时，守护线程销毁，最典型的应用就是gc垃圾回收器
        Thread t = new MyThread();
        t.setDaemon(true);
        t.start();
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("end");
    }

    static class MyThread extends Thread {
        @Override
        public void run() {
            super.run();
            int i = 0;
            while (true) {
                i++;
                System.out.println(i);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
