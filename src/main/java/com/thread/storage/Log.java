package com.thread.storage;

public class Log {

    //线程变量
    private static final ThreadLocal<TSLog> tsLogCollection = new ThreadLocal<TSLog>();

    //第一次调用时候注册一个日志
    public static TSLog getTSLog() {
        TSLog tsLog = tsLogCollection.get();
        if (tsLog == null) {
            tsLog = new TSLog(Thread.currentThread().getName() + "-log.txt");
            tsLogCollection.set(tsLog);
        }

        return tsLog;

    }

    public static void println(String s){
       getTSLog().println(s);
    }

    public static void close(){
        getTSLog().close();
    }
}
