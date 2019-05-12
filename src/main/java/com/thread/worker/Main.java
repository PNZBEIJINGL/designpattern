package com.thread.worker;

public class Main {

    public static void main(String[] args){
        //第一1个传递工作任务的管道
        Channel channel=new Channel(5);
        channel.startWorkers();

        new ClientThread("Alice",channel).start();
        new ClientThread("Bobby",channel).start();
        new ClientThread("chris",channel).start();
    }
}
