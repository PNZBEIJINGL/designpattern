package com.thread.singleexecution;

public class Gate {
    private int counter=0;
    private String name="Nobody";
    private String address="NoWhere";

    /**
     * 穿过门时候输出详情.增加synchronized 保证只有1个线程访问，Gate就变成安全的类
     * @param name
     * @param address
     */
    public synchronized void pass(String name,String address){
        this.counter++;
        this.name=name;
        this.address=address;
        check();
    }

    private void check() {
        if(name.charAt(0)!=address.charAt(0)){
            System.out.println("****** BROKEN ******"+this.toString()) ;
        }
    }

    public synchronized String toString() {
        return "No."+counter+":"+name+" | "+address;
    }
}
