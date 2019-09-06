package com.programing.locks.readwrite;

public class TestRead {

    public static void main(String[] args) {
        ReadWriteService service=new ReadWriteService();
        ReadThread a=new ReadThread(service,"Thread A");
        ReadThread b=new ReadThread(service,"Thread B");
        a.start();
        b.start();
    }

}
