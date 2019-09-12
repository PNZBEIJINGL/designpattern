package com.programing.unsafe;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class SimpleDateFormatThread extends Thread {

    private SimpleDateFormat sdf;
    private String dateString;

    public SimpleDateFormatThread(SimpleDateFormat sdf, String dateString) {
        this.sdf = sdf;
        this.dateString = dateString;
    }

    @Override
    public void run() {
        //测试传入日期和转换日期是否一致
        try {
            //sdf = new SimpleDateFormat("yyyy-MM-dd");  //创建线程自己的SimpleDateFormat 才能解决这个问题
            Date dateRef = sdf.parse(dateString);   //使用公共的SimpleDateFormat 线程不安全
            String newDateString = sdf.format(dateRef).toString();
            if (!newDateString.equals(dateString)) {
                System.out.println(Thread.currentThread().getName() + " 报错：" + dateString + " =>" + newDateString);
            }
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }
}
