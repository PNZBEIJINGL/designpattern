package com.thread.suspension;

import java.util.LinkedList;
import java.util.Queue;

public class RequestQueue {

    private final Queue<Request> queue = new LinkedList<Request>();

    public synchronized Request getRequest() {
        //如果队列中存在元素就返回头元素，否则返回空，线程等待
        while (queue.peek() == null) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        //移除队列的第一个元素，如果一个元素都没有就会抛出异常
        return queue.remove();
    }

    public synchronized void putRequest(Request request) {
        queue.offer(request);
        notify();
    }

}
