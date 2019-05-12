package com.thread.worker;

public class Channel {

    //请求任务的队列数组，最多100个任务
    private final Request[] requestQueue;
    private static final int MAX_REQUEST = 100;

    //处理该管道任务的工人
    private final WorkThread[] workThread;

    private int tail;
    private int head;
    private int count;

    /**
     * 创建1个工作管道，并设置几个工人工作
     * @param threads
     */
    public Channel(int threads) {
        this.requestQueue = new Request[MAX_REQUEST];
        this.head = 0;
        this.tail = 0;
        this.count = 0;

        //初始化工人并让线程开始工作
        workThread = new WorkThread[threads];
        for (int i = 0; i < workThread.length; i++) {
            //工人开始工作的时候调用takeRequst获取管道中的请求，没有请求时候等待
            workThread[i]=new WorkThread("Worker-"+i,this);

        }
    }

    public void startWorkers() {
        for (int i = 0; i < workThread.length; i++) {
            workThread[i].start();
        }
    }

    /**
     * 向管道中投递请求任务,当管道中没有位置时候等待
     * @param request
     */
    public synchronized void putRequest(Request request) {
        while (count >= requestQueue.length) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        //当管道中有位置的时候设置请求位置，向最后一个放，并唤醒阻塞线程
        requestQueue[tail] = request;
        tail = (tail + 1) % requestQueue.length;
        count++;
        notifyAll();
    }

    /**
     * 获取管道中的请求，
     * @return
     */
    public synchronized Request takeRequest() {
        //如果没有请求时候等待
        while (count <= 0) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        //有请求时从第0个开始取， 并唤醒其他等待线程
        Request request = requestQueue[head];
        head = (head + 1) % requestQueue.length;
        count--;
        notifyAll();
        return request;
    }
}
