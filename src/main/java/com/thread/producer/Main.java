package com.thread.producer;

public class Main {

    public static void main(String[] args) {
        Table table = new Table(3);
        new MakerThread("MakeThread-1", table, 31415).start();
        new MakerThread("MakeThread-2", table, 92653).start();
        new MakerThread("MakeThread-3", table, 58979).start();
        new EaterThread("EaterThread-1", table, 32384).start();
        new EaterThread("EaterThread-2", table, 62643).start();
        new EaterThread("EaterThread-3", table, 38372).start();

    }
}
