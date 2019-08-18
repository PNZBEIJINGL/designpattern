package com.programing.communication;

public class ThreadB extends Thread {

    private Object lock;
    public ThreadB(Object lock){
        super();
        this.lock=lock;
    }

    public void run(){
        synchronized (lock){
            for (int i = 0; i < 10; i++) {
                MyList.add();
                if(MyList.size()==5){
                    lock.notify();
                    System.out.println("do notify");

                }
                System.out.println("add "+(i+1)+"!");
            }
        }
    }

}
