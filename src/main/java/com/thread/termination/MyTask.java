package com.thread.termination;

import java.util.Random;
import java.util.concurrent.CountDownLatch;

public class MyTask implements Runnable{

    private final int count;
    private final CountDownLatch doneLatch;
    private static final Random randome=new Random(314159);

    public MyTask(CountDownLatch downLatch,int i){
        this.doneLatch=downLatch;
        this.count =i;
    }

    public void run() {
        doTask();
        //任务完成计数-1
        doneLatch.countDown();
    }

    private void doTask() {
        String name=Thread.currentThread().getName();
        System.out.println(name+":Mytask i="+ count);

        try {
            Thread.sleep(randome.nextInt(3000));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(name+":Mytask end i="+ count);
    }
}
