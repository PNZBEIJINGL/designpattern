package com.programing.access;

public class Task {

    private String str1;
    private String str2;

    /**
     * 如果doTask加锁 访问时候获取锁其他等待执行时候需要再等待3秒
     * 使用同步块加锁，不会出现脏读
     *
     * @throws InterruptedException
     */
    public void doTask() throws InterruptedException {
        System.out.println("begin");

        Thread.sleep(3000);
        String str3 = Thread.currentThread().getName();
        String str4 = Thread.currentThread().getName();

        synchronized (this) {
            str1 = str3;
            str2 = str4;
        }

        System.out.println(str1);
        System.out.println(str2);

        System.out.println("end");
    }


}
