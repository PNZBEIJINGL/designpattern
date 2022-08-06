package com.java.concurrent;

import java.util.concurrent.Semaphore;

public class SemaphoreTest {

    public static void main(String[] args) throws InterruptedException {
        //测试信号量为2
        Semaphore semaphore=new Semaphore(2);

        for (int i = 0; i < 10; i++) {
            Thread thread=new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        semaphore.acquire();
                        System.out.println(Thread.currentThread().getName()+" in");
                        int time=5000;
                        Thread.sleep(time);
                        System.out.println(Thread.currentThread().getName()+":semaphore#release ,after "+time/1000+"s");
                        semaphore.release();;
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                }
            },"Thread No."+i);
            thread.start();
        }
    }
}
