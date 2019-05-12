package com.thread.premessage;

/**
 * 真正处理任务的对象，可以是一个helper.也可以是一个Context对象
 */
public class Helper {
    public void handle(int count, char c) {
        System.out.println("   handle(" + count + "," + c + ") begin");
        for (int i = 0; i < count; i++) {
            slowly();
            System.out.print(c);
        }
        System.out.println();
        System.out.println("   handle(" + count + "," + c + ") end");
    }

    private void slowly() {

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
