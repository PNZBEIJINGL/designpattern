package com.programing.join;

public class JoinThread extends Thread {
    @Override
    public void run() {
        System.out.println("start "+System.currentTimeMillis());
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("end Thread");
    }


    public static void main(String[] args) throws InterruptedException {
        JoinThread thread=new JoinThread();
        thread.start();
        //主线程等待2秒
        thread.join(2000);
        System.out.println("  end "+System.currentTimeMillis());
    }
}
