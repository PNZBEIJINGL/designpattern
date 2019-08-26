package com.programing.join;

public class JoinLockThreadA extends Thread {

    private JoinLockThreadB threadB;
    public JoinLockThreadA(JoinLockThreadB threadB){
        super();
        this.threadB=threadB;
    }

    @Override
    public void run() {
         synchronized (threadB){
             System.out.println("Thread a start");
             try {
                 Thread.sleep(4000);
             } catch (InterruptedException e) {
                 e.printStackTrace();
             }
             System.out.println("Thread a end");

         }
    }
}
