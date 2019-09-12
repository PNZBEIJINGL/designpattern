package com.programing.unsafe;

import java.text.SimpleDateFormat;

public class SimpleDateFormatTest {

    public static void main(String[] args) {

        //从结果中可以查看到SimplateDateFormat类再多线程环境中处理日期很容易出现转换错误
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String[] dateStrings = new String[]{"2018-01-01", "2018-01-02", "2018-01-03", "2018-01-04", "2018-01-05", "2018-01-06", "2018-01-07", "2018-01-08", "2018-01-09"};

        for (int i = 0; i < dateStrings.length; i++) {
            SimpleDateFormatThread thread = new SimpleDateFormatThread(sdf, dateStrings[i]);
            thread.start();
        }
    }

}
