package com.headfirst.decorator;

/**
 * 蒸馏咖啡
 */
public class Espresso extends Beverage {

    public Espresso() {
        description = " The Espresso ";
    }

    /**
     * 价格
     *
     * @return
     */
    public double cost() {
        return 1.99;
    }
}
