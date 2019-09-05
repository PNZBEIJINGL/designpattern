package com.programing.locks.oneonone;

public class TestOneOnOne {
    public static void main(String[] args) {
        //测试， 2个线程交替处理
        Printer printer = new Printer();
        Thread4Set thread4Set = new Thread4Set(printer);
        Thread4Get thread4Get = new Thread4Get(printer);
        thread4Set.start();
        thread4Get.start();
    }
}
