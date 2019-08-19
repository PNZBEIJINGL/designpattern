package com.programing.waitnotify;

public class DBTool {

    volatile private boolean prevIsA = false;

    synchronized public void backUpA() {
        while (prevIsA == true) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        for (int i = 0; i < 5; i++) {
            System.out.println("backup A:********");
        }
        prevIsA = true;
        notifyAll();
    }

    synchronized public void backUpB() {
        while (prevIsA == false) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        for (int i = 0; i < 5; i++) {
            System.out.println("backup B:********");
        }
        prevIsA = false;
        notifyAll();
    }

    public static void main(String[] args) {
        DBTool dbTool = new DBTool();
        for (int i = 0; i < 20; i++) {
            BackUpA backUpA = new BackUpA(dbTool);
            backUpA.start();

            BackUpB backUpB = new BackUpB(dbTool);
            backUpB.start();


        }
    }


}
