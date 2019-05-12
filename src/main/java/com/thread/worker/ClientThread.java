package com.thread.worker;

import java.util.Random;

public class ClientThread extends Thread {

    private final Channel channel;
    private static final Random randome = new Random();

    public ClientThread(String name, Channel channel) {
        super(name);
        this.channel = channel;
    }

    public void run() {
        try {
            for (int i = 0; true; i++) {
                Request request = new Request(getName(), i);
                channel.putRequest(request);

                Thread.sleep(randome.nextInt(2000));

            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
