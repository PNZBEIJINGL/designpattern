package com.programing.timer;

import java.util.Calendar;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

public class TestTimer extends TimerTask {


    public void run() {
        System.out.println("任务执行了，时间为" + new Date());
    }

    public static void main(String[] args) throws InterruptedException {

        System.out.println("晚于当前时间测试：当前时间" + new Date());
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.SECOND, 5);
        Date runDT = calendar.getTime();
        TestTimer task = new TestTimer();
        //Timer启动一个新线程,如果这个线程不是守护线程会一直运行
        //true表示Timer创建的线程是守护线程， 主线程结束子线程销毁
        Timer timer = new Timer(true);
        timer.schedule(task, runDT);
        Thread.sleep(6000); //等待task执行完


        System.out.println("早于当前时间测试：当前时间" + new Date());
        Calendar calendar2 = Calendar.getInstance();
        calendar2.add(Calendar.SECOND, -5);
        runDT = calendar2.getTime();
        Timer timer2 = new Timer(true);
        TestTimer task2 = new TestTimer();
        timer2.schedule(task2, runDT);
        Thread.sleep(6000);

    }
}
