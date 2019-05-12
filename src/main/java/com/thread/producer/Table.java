package com.thread.producer;

import java.util.concurrent.ArrayBlockingQueue;

/**
 * 桌子，table类基本等同于ArrayBlockingQueue，可以使用TableQueue替换
 */


public class Table {

    private final String[] cakespace;
    private int tail; //放蛋糕的位置
    private int head; //取蛋糕的位置
    private int count;//桌子上有多少蛋糕


    public Table(int count) {
        this.cakespace = new String[count];
        this.head = 0;
        this.tail = 0;
        this.count = 0;
    }


    public synchronized void put(String cake) throws InterruptedException {
        //蛋糕放到桌子上的行为,同一时间只能放一个蛋糕
        System.out.println(Thread.currentThread().getName() + " puts " + cake);
        while (count >= cakespace.length) {
            wait();
        }

        cakespace[tail] = cake;
        tail = (tail + 1) % cakespace.length;
        count++;
        notifyAll();
    }

    public synchronized String take() throws InterruptedException {
        //从桌子上拿走蛋糕的行为,同一时间只能提取一个蛋糕
        while (count <= 0) {
            wait();
        }

        String cake = cakespace[head];
        head = (head + 1) % cakespace.length;
        count--;
        notifyAll();
        System.out.println(Thread.currentThread().getName() + " take  " + cake);
        return cake;
    }


/*
public class Table extends ArrayBlockingQueue<String>{
    public Table(int capacity) {
        super(capacity);
    }

    public void put(String cake) throws InterruptedException {
        System.out.println(Thread.currentThread().getName() + " puts " + cake);
        super.put(cake);
    }

    public String take() throws InterruptedException {
        String cake = super.take();
        System.out.println(Thread.currentThread().getName() + " takes " + cake);
        return cake;
    }
    */

}
