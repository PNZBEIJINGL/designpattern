package com.programing.access;

public class VolatileTestThread extends Thread {

    volatile private boolean isRunning = true;

    public boolean isRunning() {
        return isRunning;
    }

    public void setRunning(boolean running) {
        isRunning = running;
    }

    public void run() {
        System.out.println(" in run");
        while (isRunning == true) {
            try {
                sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println(" do end");
    }

    /**
     * 在jvm 被设置为-server模式时为了线程运行的效率，线程一直在私有堆栈中获取成员变量
     * thread.setRuning(false)虽然执行更新的是公共栈，私有栈和共有栈的值不同会造成问题
     * 使用volatile关键字当访问时,强制性从公共堆栈中取值
     * @param args
     * @throws InterruptedException
     */
    public static void main(String[] args) throws InterruptedException {
        VolatileTestThread thread = new VolatileTestThread();
        thread.start();
        Thread.sleep(1000);
        //设置线程停止工作
        thread.setRunning(false);
        System.out.println("test end");
    }
}
