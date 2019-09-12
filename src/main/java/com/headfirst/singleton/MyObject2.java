package com.headfirst.singleton;

public class MyObject2 {

    private static MyObject2 instance = null;

    private MyObject2() {
    }

    //静态代码块中的代码再使用类的时候就已经执行了
    static {
        instance = new MyObject2();
    }

    public static MyObject2 getInstance() {
        return instance;
    }
}
