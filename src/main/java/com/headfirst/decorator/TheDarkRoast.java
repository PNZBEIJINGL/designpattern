package com.headfirst.decorator;

/**
 * 深度烘培咖啡
 */
public class TheDarkRoast extends Beverage {

    public TheDarkRoast() {
        this.description = "The DarkRoast coffee";
    }

    /**
     * @return
     */
    public double cost() {
        return 3;
    }
}
