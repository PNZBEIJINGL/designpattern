/***********************************************************************
 *
 * @copyright Copyright: 2002-2015 Beijing Startimes
 * Software Technology Co. Ltd.
 * @creator 10001874 10001874@startimes.com.cn
 * @create-time 2018-5-31 11:52:06
 * @revision $Id: TransactionGuarded.java,v 1.1.2.6 2018/11/26 07:08:55 liuyong Exp $
 *
 ***********************************************************************/
package com.used.batch;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author LIUY
 */
public class TransactionGuarded {

    private final int number;
    private AtomicInteger currentNum = new AtomicInteger(0);

    private State status;

    protected enum State {
        FAILED, WORKING, SUCESSES;
    }

    public TransactionGuarded(int number) {
        this.number = number;
        this.status = State.WORKING;
    }

    public synchronized boolean isSuccess() {
        return State.SUCESSES == status;
    }

    public synchronized void hold(String threadName)
            throws InterruptedException {
        if (!status.equals(State.WORKING)) {
            return;
        }

        int num = currentNum.incrementAndGet();
        if (num == number) {
            status = State.SUCESSES;
            weakUpAll();
        } else {
            doHold();
        }
    }

    public synchronized void setFailed() {
        if (!status.equals(State.FAILED)) {
            status = State.FAILED;
            weakUpAll();
        }
    }

    private void doHold() throws InterruptedException {
        try {
            this.wait(45 * 60 * 1000);
            if (status.equals(State.WORKING)) {
                setFailed();
            }
        } catch (Exception e) {
            setFailed();
        }
    }


    private void weakUpAll() {
        this.notifyAll();
    }

}
