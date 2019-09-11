package com.programing.timer;

import java.util.Calendar;
import java.util.Date;
import java.util.Timer;

public class TestCancel {
    public static void main(String[] args) {

        System.out.println("晚于当前时间测试：当前时间" + new Date());
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.SECOND, 1);

        Date runDT = calendar.getTime();
        TimeTaskA task = new TimeTaskA();
        TimeTaskB taskb = new TimeTaskB();
        //设置延迟N秒执行,4秒轮询
        Timer timer = new Timer();
        timer.schedule(task, runDT, 3000);
        timer.schedule(taskb, runDT, 3000);
    }
}
