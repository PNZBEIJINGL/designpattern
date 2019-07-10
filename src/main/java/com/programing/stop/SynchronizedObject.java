package com.programing.stop;

/**
 * 使用stop释放锁会给数据造成不一致的结果，对数据造成破坏
 * 测试用例：
 */
public class SynchronizedObject {
    private String username = "a";
    private String password = "aa";

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    synchronized public void printString(String username, String password) {
        try {
            this.username = username;
            Thread.sleep(100000);
            this.password = password;
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


    //test
    public static void main(String[] args) {
        SynchronizedObject object = new SynchronizedObject();
        Mythread mythread = new Mythread(object);
        mythread.start();
        try {
            Thread.sleep(500);
            mythread.stop();
            System.out.println(object.getUsername() + "  " + object.getPassword());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}

class Mythread extends Thread {
    private SynchronizedObject object;

    public Mythread(SynchronizedObject object) {
        super();
        this.object = object;
    }

    public void run() {
        object.printString("b", "bb");
    }
}
