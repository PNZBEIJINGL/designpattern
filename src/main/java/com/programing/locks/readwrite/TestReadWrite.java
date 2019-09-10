package com.programing.locks.readwrite;

public class TestReadWrite {
    public static void main(String[] args) throws InterruptedException {

        ReadWriteService service = new ReadWriteService();
        WriteThread writeThread2 = new WriteThread(service, "Write 2");
        writeThread2.start();

        ReadThread readThread = new ReadThread(service, "Read  1");
        readThread.start();

        WriteThread writeThread = new WriteThread(service, "Write 1");
        writeThread.start();

        //结果相差1000.即1S
    }
}
