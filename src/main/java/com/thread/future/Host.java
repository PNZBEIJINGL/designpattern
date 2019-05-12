package com.thread.future;

public class Host {

    public IData request(final int count, final char c) {
        System.out.println("    request(" + count + "," + c + ") begin");

        //创建一个futureData实例
        final FutureData future = new FutureData();

        //启动一个线程用于创建RealData 实例
        new Thread() {
            public void run() {
                RealData realData = new RealData(count, c);
                future.setRealdata(realData);
            }
        }.start();

        System.out.println("       request(" + count + "," + c + ") end");
        //先得到futuredata, 这个实现线程还没有执行完
        return future;
    }
}
