package com.programing.timer;

import java.util.Date;
import java.util.TimerTask;

public class TimeTaskB extends TimerTask {

    public void run() {

        try {
            System.out.println("B 任务执行，时间为" + new Date());
            //this.cancel();
            System.out.println("B CANCEL ，时间为" + new Date());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
