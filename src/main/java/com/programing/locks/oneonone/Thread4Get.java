package com.programing.locks.oneonone;

public class Thread4Get extends Thread {
    private Printer printer;

    public Thread4Get(Printer printer) {
        this.printer = printer;
    }

    public void run() {
        printer.get();
    }
}
