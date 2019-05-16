package com.headfirst.decorator;

/**
 * 黑咖啡
 */
public class TheHouseBlend extends Beverage {

    public TheHouseBlend() {
        description = "The House Blend Coffee";
    }

    /**
     * 价格
     *
     * @return
     */
    public double cost() {
        return 0.89;
    }
}
