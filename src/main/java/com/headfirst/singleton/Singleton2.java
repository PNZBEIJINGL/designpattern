package com.headfirst.singleton;

/**
 * 线程安全,但是高并发性能不是很好
 * synchronized同步锁造成请求都等待
 */
public class Singleton2 {
    private static Singleton2 instance;

    private Singleton2() {
    }

    public static synchronized Singleton2 getInstance() {
        if (instance == null) {
            instance = new Singleton2();
        }
        return instance;
    }
}
