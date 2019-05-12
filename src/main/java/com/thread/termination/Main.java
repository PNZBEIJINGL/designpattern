package com.thread.termination;

public class Main {

    public static void main(String[] args) throws InterruptedException {
        System.out.println("main:START");
        CountupThread t = new CountupThread();
        t.start();
        Thread.sleep(5000);

        System.out.println("main:shutdownRequest!");
        t.setShutdownRequeste();

        System.out.println("main:join");
        t.join();
        //join 方法是用于等待线程终止的方法，再制定的线程终止前， join方法不会返回
        // 即当打印t.shutdown之后程序才会往下走

        System.out.println("main:END");
    }

}
