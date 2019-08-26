package com.programing.threadlocal;

import java.util.Date;

public class ThreadLocalExt extends ThreadLocal {
    @Override
    protected Object initialValue() {
        //return super.initialValue();
        return new Date();
    }

    public static void main(String[] args) {

        //通过覆写initialValue 解决get()==null 的问题
        ThreadLocalExt threadLocalExt = new ThreadLocalExt();
        System.out.println(threadLocalExt.get());
    }
}
