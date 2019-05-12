package com.thread.worker;

/**
 * 工人线程，从工作管道中获取工作请求并执行请求
 */
public class WorkThread extends Thread {

    private final Channel channel;

    public WorkThread(String name, Channel channel) {
        super(name);
        this.channel = channel;
    }

    public void run() {
        while (true) {
            Request request = channel.takeRequest();
            request.execute();;
        }
    }

}
