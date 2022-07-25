package com.headfirst.singleton;

import java.util.concurrent.locks.ReentrantLock;

/**
 * 线程安全,性能又高
 * synchronized同步锁造成请求都等待
 */
public class Singleton4 {
    private static Singleton4 instance;

    private static ReentrantLock lock = new ReentrantLock();

    private Singleton4() {
    }

    public static Singleton4 getInstance() {
        if (instance == null) {
            //加锁实现等待
            lock.lock();
            //第一个请求new
            //第二个请求instance！=null
            if (instance == null) {
                instance = new Singleton4();
            }

            lock.unlock();
        }
        return instance;
    }
}
