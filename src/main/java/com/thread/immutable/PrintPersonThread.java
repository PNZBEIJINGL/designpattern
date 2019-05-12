package com.thread.immutable;

import java.util.Random;

public class PrintPersonThread extends Thread {
    private final Random random=new Random(1);
    private Person person;

    public PrintPersonThread(Person person) {
        this.person = person;
    }

    public void run() {
        while (true) {
            System.out.println(Thread.currentThread().getName() + " print " + person.getName());
            try {
                Thread.sleep(random.nextInt(1000));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }


}
