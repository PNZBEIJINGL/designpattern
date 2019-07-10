package com.programing.stop;

/**
 *
 */
public class SleepThread extends Thread {

    public  void run(){
        super.run();
        System.out.println("run begin");
        try {
            Thread.sleep(20000);
            System.out.println("run end");
        } catch (InterruptedException e) {
            //sleep 状态下停止会直接进入 catch
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        SleepThread thread=new SleepThread();
        thread.start();
        try {
            thread.sleep(200);
            thread.interrupt();
        } catch (InterruptedException e) {
            System.out.println("catch");
            e.printStackTrace();
        }
        System.out.println("end");
    }

}
