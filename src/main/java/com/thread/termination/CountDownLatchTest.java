package com.thread.termination;

import java.util.concurrent.*;

public class CountDownLatchTest {

    private static final int TASKS=10;

    public static void main(String[] args){
        System.out.println("Begin");

        ExecutorService service= Executors.newFixedThreadPool(5);
        CountDownLatch doneLatch=new CountDownLatch(TASKS);

        for (int t = 0; t < TASKS; t++) {
            service.execute(new MyTask(doneLatch,t));
        }

        System.out.println("waiting");

        try {
            doneLatch.await();
            System.out.println("continue："+doneLatch.getCount());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally{
            service.shutdown();
            System.out.println("End");
        }
    }

}
