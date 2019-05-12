package com.thread.producer;

import java.util.Random;

/**
 * 生产者
 */
public class MakerThread extends Thread {

    private final Random random;
    private final Table table;
    private static int id = 0;

    public MakerThread(String name, Table table, long seed) {
        super(name);
        this.table = table;
        this.random = new Random(seed);
    }

    /**
     * 创建蛋糕然后放到桌子上
     */
    public void run() {
        try {
            while (true) {
                Thread.sleep(random.nextInt(1000));
                String cake = "[Cake No." + nextId() + " by " + getName() + "]";
                table.put(cake);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private synchronized int nextId() {
        return id++;
    }

}
