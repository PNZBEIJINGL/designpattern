package com.programing.locks.manytomany;

import com.programing.locks.oneonone.Printer;
import com.programing.locks.oneonone.Thread4Get;
import com.programing.locks.oneonone.Thread4Set;

public class TestMany2Many {

    public static void main(String[] args) {

        Printer printer = new Printer();
        Thread4Set[] thread4Sets = new Thread4Set[10];
        Thread4Get[] thread4Gets = new Thread4Get[10];

        //问题1：处理会假死
        // 将Printer中 condition.signal()修改为 signalAll ，假死问题解决，但是输入非交替进行的因为signalAll唤醒线程时，唤醒的可能是同一个类
        for (int i = 0; i < 10; i++) {
            thread4Sets[i] = new Thread4Set(printer);
            thread4Gets[i] = new Thread4Get(printer);
            thread4Sets[i].start();
            thread4Gets[i].start();
        }

    }
}
