package com.headfirst.adapter;

/**
 * 缺少鸭子对象用火鸡冒充
 * 实现接口并在接口中转换
 */
public class TurkeyAdapter implements IDuck {

    private ITurkey turkey;

    public TurkeyAdapter(ITurkey turkey) {
        this.turkey = turkey;
    }

    public void quack() {
        this.turkey.gobble();
    }

    public void fly() {
        //多飞几次
        this.turkey.fly();
        this.turkey.fly();
        this.turkey.fly();
    }
}
