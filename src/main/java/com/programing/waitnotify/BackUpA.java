package com.programing.waitnotify;

public class BackUpA extends Thread {

    private DBTool dbTool;

    public BackUpA(DBTool dbTool) {
        super();
        this.dbTool = dbTool;
    }

    public void run() {
        dbTool.backUpA();
    }

}
