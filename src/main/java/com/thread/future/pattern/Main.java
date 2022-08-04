package com.thread.future.pattern;

import java.util.Date;

public class Main {

    public static void main(String[] args) {

        AppleStore appleStore = new AppleStore();
        String request1="IMac";
        String request2="IPhone";
        System.out.println("张三买"+request1);
        System.out.println("李四买"+request1);

        IOrder order1 = appleStore.createOrder(request1);
        IOrder order2 = appleStore.createOrder(request2);
        System.out.println(new Date()+"苹果店发放完成提货单");
        System.out.println();

        System.out.println(new Date()+"张三取" + order1.getProduct().getName());
        System.out.println(new Date()+"李四取" + order2.getProduct().getName());

    }
}
