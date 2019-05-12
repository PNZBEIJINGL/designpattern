package com.thread.termination;

public class CountupThread extends Thread {
    private long counter = 0;

    private volatile boolean shutdownRequested = false;

    public void setShutdownRequeste() {
        shutdownRequested = true;
        interrupt();
    }

    public boolean isShutdownRequest() {
        return shutdownRequested;
    }

    /**
     * 循环：判断是否有关闭请求，若果没有关闭亲求则计数，否则关闭
     */
    public final void run() {

        try {
            while (!isShutdownRequest()) {
                doWork();
            }
        } catch (InterruptedException e) {
            //e.printStackTrace();
        } finally {
            doShutdown();
        }
    }

    private void doShutdown() {
        System.out.println("doShutdown:counter" + counter);
    }

    private void doWork() throws InterruptedException {

        counter++;
        System.out.println(" do work :counter=" + counter);

        Thread.sleep(500);
    }

}
