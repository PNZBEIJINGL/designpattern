package com.thread.balking;

/**
 * 可以修改并保存的数据类
 */
public class Data {

    private final String filename;
    private String content;
    private boolean changed;  //守护条件

    public Data(String filename, String content) {
        this.filename = filename;
        this.content = content;
        this.changed = true;
    }

    public synchronized void change(String newcontent) {
        this.content = newcontent;
        changed = true;
    }

    public synchronized void save() {
        if (!changed) {
            return;
        }
        doSave();
        changed = false;
    }

    private void doSave() {
        System.out.println(Thread.currentThread().getName() + " calls dosave:" + content);


    }

}
