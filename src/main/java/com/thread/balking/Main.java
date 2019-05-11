package com.thread.balking;

public class Main {

    public static void main(String[] args) {
        Data data = new Data("data.txt", "empty");
        new ChangerThread("ChangThread",data).start();
        new SaverThread("savingThread",data).start();
    }
}
