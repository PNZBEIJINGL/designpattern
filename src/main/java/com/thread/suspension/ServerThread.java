package com.thread.suspension;

import java.util.Random;

/**
 * 接收请求的线程
 */
public class ServerThread extends Thread {

    private final Random random;

    private final RequestQueue requestQueue;

    public ServerThread(RequestQueue requstQueue, String name, long seed) {
        super(name);
        this.requestQueue = requstQueue;
        this.random = new Random(seed);

    }

    /**
     * 循环从队列中获取元素， 当获取元素的时候如果没有得到，requestQueue 会=》wait 等待
     */
    public void run() {
        for (int i = 0; i < 1000; i++) {
            Request request = requestQueue.getRequest();
            System.out.println(" => "+Thread.currentThread().getName() + "handles" + request);
            try {
                Thread.sleep(random.nextInt(1000));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}
