package com.thread.singleexecution;

public class UserThread extends Thread{

    private final Gate gate;
    private final String myname;
    private final String myaddress;

    public UserThread(Gate gate,String myname,String myaddress){
        this.gate=gate;
        this.myaddress=myaddress;
        this.myname=myname;
    }

    //无限循环某个人在穿过门
    public void run(){
        System.out.println(myname+" Begin");
        while (true){
            gate.pass(myname,myaddress);
        }
    }
}
