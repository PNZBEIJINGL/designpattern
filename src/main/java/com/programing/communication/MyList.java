package com.programing.communication;

import java.util.ArrayList;
import java.util.List;

public class MyList {

    private static List list = new ArrayList();

    public static void add() {
        list.add("any");

    }

    public static int size() {
        return list.size();
    }

    public static void main(String[] args) {
        Object lock=new Object();
        ThreadA a=new ThreadA(lock);
        a.start();

        ThreadB b=new ThreadB(lock);
        b.start();
    }
}
