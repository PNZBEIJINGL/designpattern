package com.thread.storage;

public class ClientThread extends Thread {

    public ClientThread(String name) {
        super(name);
    }

    public void run() {
        System.out.println(getName() + " Begin ");
        try {
            for (int i = 0; i < 10; i++) {
                Thread.sleep(100);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Log.close();

        System.out.println(getName() + " End ");
    }
}
