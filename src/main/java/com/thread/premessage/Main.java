package com.thread.premessage;

public class Main {
    public static void main(String[] args){
        System.out.println("Main begin");
        Host host=new Host();
        host.request(10,'A');
        host.request(20,'b');
        host.request(30,'c');
        System.out.println("Main end");
    }
}
