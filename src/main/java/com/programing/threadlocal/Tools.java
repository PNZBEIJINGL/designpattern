package com.programing.threadlocal;

public class Tools {

    public static ThreadLocal t1 = new ThreadLocal();

    public static void main(String[] args) {
        //验证没有赋值时候 get()==null
        System.out.println(t1.get());
    }
}
