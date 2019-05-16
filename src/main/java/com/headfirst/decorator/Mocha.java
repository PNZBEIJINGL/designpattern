package com.headfirst.decorator;

/**
 * 摩卡（就是巧克力风味）
 */
public class Mocha extends CondimentDecortor {
    Beverage beverage;

    public Mocha(Beverage beverage) {
        this.beverage = beverage;
    }

    public String getDescription() {
        return beverage.getDescription() + ",+ Mocha";
    }

    /**
     * 价格增加0.20
     * @return
     */
    public double cost() {
        return 0.20 + beverage.cost();
    }
}
