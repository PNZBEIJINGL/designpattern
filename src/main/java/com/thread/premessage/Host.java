package com.thread.premessage;

public class Host {

    private final Helper helper = new Helper();

    public void request(final int count, final char c) {
        System.out.println("   request(" + count + "," + c + ") begin");
        /*
        new Thread() {
            public void run() {
                helper.handle(count, c);
            }
        }.start();
        */

        Runnable runable = new Runnable() {
            public void run() {
                helper.handle(count, c);
            }
        };
        new Thread(runable).start();
        System.out.println("   request(" + count + "," + c + ") end");
    }

}
