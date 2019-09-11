package com.programing.timer;

import java.util.Date;
import java.util.TimerTask;

public class TimeTaskA extends TimerTask {

    public void run() {

        try {
            System.out.println("任务执行了，时间为" + new Date());
            Thread.sleep(4000);
            System.out.println("任务结束了，时间为" + new Date());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
