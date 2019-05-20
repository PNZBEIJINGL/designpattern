package com.headfirst.adapter;

/*
 * 适配器是指将一个类的接口，转换成客户期望的另一个接口
 * 适配器可以解决接口不兼容的问题
 */
public class DuckTestDrive {
    public static void main(String[] args) {
        MallardDuck duck = new MallardDuck();
        WildTurkey turkey = new WildTurkey();

        IDuck turkeyAdapter = new TurkeyAdapter(turkey);

        duck.quack();
        duck.fly();

        turkeyAdapter.quack();
        duck.fly();
    }
}
