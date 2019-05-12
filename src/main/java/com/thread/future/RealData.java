package com.thread.future;

public class RealData implements IData {

    private final String content;

    public RealData(int count, char c) {
        System.out.println("       making RealData(" + count + "," + c + ") Begin");

        char[] buffer = new char[count];

        for (int i = 0; i < count; i++) {
            buffer[i] = c;
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("      making RealData" + count + "," + c + ") end");
        this.content = new String(buffer);

    }

    public String getContent() {
        return content;
    }
}
