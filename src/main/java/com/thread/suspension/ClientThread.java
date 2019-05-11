package com.thread.suspension;

import java.util.Random;

/**
 * 用于发送请求
 */
public class ClientThread extends Thread {

    private final Random random;

    private final RequestQueue requestQueue;

    public ClientThread(RequestQueue requstQueue, String name, long seed) {
        super(name);
        this.requestQueue = requstQueue;
        this.random = new Random(seed);

    }

    /**
     * 每秒都创建1个请求，并将请求存放到队列requestQueue中
     */
    public void run() {
        for (int i = 0; i < 1000; i++) {
            Request request = new Request("No." + i);
            System.out.println(Thread.currentThread().getName() + "requests" + request);
            requestQueue.putRequest(request);
            try {
                Thread.sleep(random.nextInt(1000));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }

}
