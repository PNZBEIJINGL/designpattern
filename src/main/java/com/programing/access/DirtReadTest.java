package com.programing.access;

/**
 * 赃读问题测试
 */
public class DirtReadTest {

    /**
     * 脏读出现在操作谁变量的情况下，不同线程争抢变量
     *
     * @param args
     * @throws InterruptedException
     */
    public static void main(String[] args) throws InterruptedException {
        PublicVar publicVar = new PublicVar();
        ThreadA threadA = new ThreadA(publicVar);
        //执行后用户名先被修改成b，等待其他服务执行5秘
        threadA.start();
        ThreadA.sleep(200);
        //这个时候线程正在等待中
        publicVar.getValue();
    }
}
