package com.programing.access;

public class Service {
    private String username;
    private String password;
    private String ip;

    public void setUser1(String usrename, String password) throws InterruptedException {

        //ip是私有成员，synchronized（非this）场景下，多个线程访问让然会被阻塞一个线程一个线程访问
        synchronized (ip) {
            this.username = usrename;
            this.password = password;
            Thread.sleep(3000);
            System.out.println(Thread.currentThread().getName());
        }
    }

    public void setUser2(String usrename, String password) throws InterruptedException {

        //synchronized（非this）场景下， 多个线程访问让然会被阻塞一个线程一个线程访问
        String ip = new String();
        synchronized (ip) {
            this.username = usrename;
            this.password = password;
            Thread.sleep(3000);
            System.out.println(Thread.currentThread().getName());
        }
    }

    //方法1是同1个对象是同步犯法
    //方法2是不同的对象因此是异步的方法
}
