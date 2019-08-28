package com.programing.locks.oneonone;

public class Thread4Set extends Thread {

    private Printer printer;

    public Thread4Set(Printer printer) {
        this.printer = printer;
    }

    public void run() {
        printer.set();
        ;
    }

}
