package com.headfirst.decorator;

/**
 * 奶泡
 */
public class Whip extends CondimentDecortor {

    private Beverage beverage;

    public Whip(Beverage beverage) {
        this.beverage = beverage;
    }

    /**
     * 描述
     *
     * @return
     */
    public String getDescription() {
        return beverage.getDescription() + " ,+Whip";
    }

    /**
     * 价格增加
     *
     * @return
     */
    public double cost() {
        return 0.3 + beverage.cost();
    }
}
