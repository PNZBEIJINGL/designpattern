package com.programing.locks.readwrite;

public class TestWrite {

    public static void main(String[] args) {
        ReadWriteService service = new ReadWriteService();
        WriteThread a = new WriteThread(service, "Thread A");
        WriteThread b = new WriteThread(service, "Thread B");
        a.start();
        b.start();
    }
}
