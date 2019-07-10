package com.programing.stop;

/**
 * stop暴力停止
 * 会有数据不一致的问题，
 *
 * @see SynchronizedObject
 */
public class CountThread extends Thread {

    private int i = 0;

    public void run() {
        while (true) {
            i++;
            System.out.println("i=" + i);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        CountThread thread = new CountThread();
        thread.start();
        try {
            thread.sleep(8000);
            thread.stop();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
