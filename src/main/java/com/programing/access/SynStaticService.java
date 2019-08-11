package com.programing.access;

public class SynStaticService {

    synchronized public static void printA() throws InterruptedException {
        System.out.println(Thread.currentThread().getName() + " 进入A " + System.currentTimeMillis());
        Thread.sleep(3000);
        System.out.println(Thread.currentThread().getName() + " 离开A " + System.currentTimeMillis());
    }

    synchronized public static void printB() throws InterruptedException {
        //System.out.println(Thread.currentThread().getName() + " 进入b " + System.currentTimeMillis());
        //System.out.println(Thread.currentThread().getName() + " 离开b " + System.currentTimeMillis());

        //synchronized（class）同步class代码块的作用和synchronized static作用一样
        synchronized (SynStaticService.class) {
            System.out.println(Thread.currentThread().getName() + " 进入b " + System.currentTimeMillis());

            System.out.println(Thread.currentThread().getName() + " 离开b " + System.currentTimeMillis());
        }
    }

    synchronized public void printC() {
        System.out.println(Thread.currentThread().getName() + " 进入c " + System.currentTimeMillis());

        System.out.println(Thread.currentThread().getName() + " 离开c " + System.currentTimeMillis());
    }

    public static void printD() {

    }

    public static void main(String[] args) {

        SynStaticService service = new SynStaticService();

        SynStaticThreadA a = new SynStaticThreadA();
        SynStaticThreadB b = new SynStaticThreadB();
        SynStaticThreadC c = new SynStaticThreadC(service);

        //不同的锁， 静态方法上增加同步锁class类
        a.start();
        b.start();
        c.start();

    }

}
