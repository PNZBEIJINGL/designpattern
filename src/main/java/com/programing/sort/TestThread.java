package com.programing.sort;

public class TestThread extends Thread {

    private Object lock;
    private String showMsg;
    private int position;  //位置顺序
    private int printCount = 0;  //打印
    volatile private static int addNumber = 1;

    public TestThread(Object lock, String showMsg, int position) {
        super();
        this.lock = lock;
        this.showMsg = showMsg;
        this.position = position;
    }

    @Override
    public void run() {
        // 线程运行时多个线程之间执行任务的时机是无序的。可以通过改造代码的方式使他们运行具有有序性
        try {
            synchronized (lock) {
                while (true) {
                    if (addNumber % 3 == position) {
                        System.out.println(Thread.currentThread().getName() + " runCount=" + addNumber + " " + showMsg);
                        lock.notifyAll();
                        addNumber++;
                        printCount++;
                        if (printCount == 1) {  //循环次数
                            break;
                        }
                    } else {
                        lock.wait();
                    }
                }
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        Object lock = new Object();
        TestThread a = new TestThread(lock, "DO A", 1);
        TestThread b = new TestThread(lock, "DO B", 2);
        TestThread c = new TestThread(lock, "DO C", 0);
        a.start();
        b.start();
        c.start();
    }
}
