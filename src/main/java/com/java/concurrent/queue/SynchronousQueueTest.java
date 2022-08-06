package com.java.concurrent.queue;

import java.util.concurrent.Semaphore;
import java.util.concurrent.SynchronousQueue;

public class SynchronousQueueTest {

    public static void main(String[] args) {

        final SynchronousQueue<String> squeue = new SynchronousQueue<String>();

        //信号量=1，充当互斥锁
        final Semaphore sem = new Semaphore(1);

        for (int i = 0; i < 5; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        sem.acquire();
                        String input = squeue.take();
                        System.out.println(Thread.currentThread().getName()+":sequeue#take:"+input);

                        String output = TestDo.doSome(input);
                        System.out.println(Thread.currentThread().getName() + ":" + output);
                        System.out.println();
                        sem.release();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                }
            }).start();
        }

        for (int j = 0; j < 5; j++) {
            String input=j+"";
            try {
                squeue.put(input);
                System.out.println(Thread.currentThread().getName()+":sequeue#input:"+j);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

class TestDo {
    public static String doSome(String input) {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        String output = input + ":" + (System.currentTimeMillis() / 1000);
        return output;
    }
}