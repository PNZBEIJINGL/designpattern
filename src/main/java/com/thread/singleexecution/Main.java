package com.thread.singleexecution;

public class Main {

    public static void main(String[] args){
        System.out.println("Tesing  Gate ,Ctrl+c exit");
        //让3个人不断通过
        Gate gate=new Gate();
        new UserThread(gate,"Alis","Beijing").start();
        new UserThread(gate,"babby","Shanghai").start();
        new UserThread(gate,"Cini","Guangzhou").start();

    }
}

