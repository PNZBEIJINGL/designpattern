package com.thread.future;

public class Main {

    public static void main(String[] args) {
        System.out.println("main begin");

        Host host = new Host();
        IData data1 = host.request(10, 'A');
        IData data2 = host.request(20, 'B');
        IData data3 = host.request(30, 'C');

        System.out.println("main other job begin");
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("main other job end");
        //host 返回的是furtureData， 获取content的时候，如果子线程获取数据还没执行完就wait等待， 如果执行完了才能得到结果
        //所以java 类库中的 future.get()方法是个阻塞方法
        System.out.println("data1=" + data1.getContent());
        System.out.println("data2=" + data2.getContent());
        System.out.println("data3=" + data3.getContent());

        System.out.println("main end!");

    }
}
