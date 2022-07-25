package com.headfirst.singleton;

/**
 * 线程安全,性能又高
 * synchronized同步锁造成请求都等待
 */
public class Singleton3 {
    private static Singleton3 instance;

    private  static byte[] lock=new byte[0];

    private Singleton3() {
    }

    public static  Singleton3 getInstance() {
        if (instance == null) {
            //加锁实现等待
            synchronized (lock){
                //第一个请求new
                //第二个请求instance！=null
                if (instance == null) {
                    instance = new Singleton3();
                }

            }
        }
        return instance;
    }
}
