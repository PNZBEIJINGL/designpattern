package com.thread.immutable;

public class Main {

    public static void main(String[] args){
        Person alice=new Person("Alice","US");
        new PrintPersonThread(alice).start();
        new PrintPersonThread(alice).start();
        new PrintPersonThread(alice).start();
    }

}
