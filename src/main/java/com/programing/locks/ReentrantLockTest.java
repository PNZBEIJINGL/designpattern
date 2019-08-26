package com.programing.locks;

public class ReentrantLockTest {

    public static void main(String[] args) {

        //lock.lock()就有了对象监听器，其他线程就需要等待，锁被释放的时候再被争夺，就和　synchronized关键字一样
        //线程间执行的顺序是随机的

        MyService service = new MyService();
        MethodAThread thread1 = new MethodAThread(service, "No.1 Thread");
        MethodAThread thread2 = new MethodAThread(service, "No.2 Thread");
        MethodAThread thread3 = new MethodAThread(service, "No.3 Thread");
        MethodAThread thread4 = new MethodAThread(service, "No.4 Thread");

        MethodBThread thread5 = new MethodBThread(service, "No.5 Thread");
        MethodBThread thread6 = new MethodBThread(service, "No.6 Thread");
        MethodBThread thread7 = new MethodBThread(service, "No.7 Thread");

        thread1.start();
        thread2.start();
        thread3.start();
        thread4.start();
        thread5.start();
        thread6.start();
        thread7.start();
    }
}
