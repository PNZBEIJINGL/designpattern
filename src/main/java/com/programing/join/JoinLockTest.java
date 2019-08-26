package com.programing.join;

public class JoinLockTest {

    public static void main(String[] args) throws InterruptedException {
        JoinLockThreadB threadB=new JoinLockThreadB();
        JoinLockThreadA threadA=new JoinLockThreadA(threadB);
        threadA.start();
        threadB.start();
        threadB.join();
        System.out.println("main end;");
    }
}
