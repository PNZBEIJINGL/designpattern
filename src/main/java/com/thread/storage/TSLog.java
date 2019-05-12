package com.thread.storage;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class TSLog {

    private PrintWriter writer = null;

    //初始化
    public TSLog(String fileName) {
        try {
            writer = new PrintWriter(new FileWriter(fileName));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //写日志
    public void println(String s) {
        writer.println(s);
    }

    //关闭日志
    public void close() {
        writer.print("====== end of log=====");
        writer.close();
    }

}
