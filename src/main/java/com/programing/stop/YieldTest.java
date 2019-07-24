package com.programing.stop;

public class YieldTest {

    public static void main(String[] args) {
        Mythread t = new Mythread();
        t.start();
    }


    public static class Mythread extends Thread {
        @Override
        public void run() {
            super.run();
            long beginTime = System.currentTimeMillis();
            int count = 0;
            for (int i = 0; i < 500000; i++) {
                //放弃当前的cup资源让给其他资源，也有肯能放弃后立即又获取了
                Thread.yield();
                count = count + i + 1;
            }
            long endTime = System.currentTimeMillis();
            System.out.println(endTime - beginTime);
        }
    }
}
