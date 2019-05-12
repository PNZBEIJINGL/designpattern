package com.thread.immutable;

public class Person {

    //使用final防止被修改
    private final String name;
    private final String address;

    public Person(String name,String address){
        this.address=address;
        this.name=name;
    }

    // 这里不能有Set方法

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }
}
