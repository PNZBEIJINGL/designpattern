package com.thread.balking;

/**
 * 对象用于定期保存数据
 */
public class SaverThread extends Thread {

    private final Data data;

    public SaverThread(String name,Data data){
        super(name);
        this.data=data;
    }

    public void run(){
        while(true){
            data.save();
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
