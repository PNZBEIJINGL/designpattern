package com.programing.waitnotify;

public class BackUpB extends Thread {

    private DBTool dbTool;

    public BackUpB(DBTool dbTool) {
        super();
        this.dbTool = dbTool;
    }

    public void run() {
        dbTool.backUpB();
    }

}
