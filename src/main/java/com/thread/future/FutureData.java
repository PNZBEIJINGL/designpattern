package com.thread.future;

import com.thread.balking.Data;

/**
 * 提货单
 */
public class FutureData implements IData {

    private RealData realdata = null;
    private boolean ready = false;

    public synchronized void setRealdata(RealData realdata) {
        if (ready) {
            return;
        }

        this.realdata = realdata;
        this.ready = true;
        notifyAll();
    }

    /**
     * 还没有返回结果时候,getContent等待
     * @return
     */
    public synchronized String getContent() {
        while (!ready) {
            try {
                wait();
            } catch (InterruptedException e) {
               // e.printStackTrace();
            }
        }
        return realdata.getContent();
    }
}
