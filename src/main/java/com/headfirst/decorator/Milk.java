package com.headfirst.decorator;

public class Milk extends CondimentDecortor {

    private Beverage beverage;

    public Milk(Beverage beverage) {
        this.beverage = beverage;
    }

    public String getDescription() {
        return beverage.getDescription() + ",+ Milk";
    }

    /**
     * 增加牛奶后总价格增加0.2
     *
     * @return
     */
    public double cost() {
        return beverage.cost() + 0.2;
    }
}
