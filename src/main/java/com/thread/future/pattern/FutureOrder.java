package com.thread.future.pattern;


/**
 * 提货单
 */
public class FutureOrder implements IOrder {

    private OrderManager virturalData = null;
    private boolean ready = false;

    public synchronized void setRealdata(OrderManager virturalData) {
        if (ready) {
            return;
        }

        this.virturalData = virturalData;
        this.ready = true;
        notifyAll();
    }

    public synchronized Product getProduct() {
        while (!ready) {
            try {
                //没有准备好的时候等待
                wait();
            } catch (InterruptedException e) {
                // e.printStackTrace();
            }
        }
        return virturalData.getProduct();
    }
}
