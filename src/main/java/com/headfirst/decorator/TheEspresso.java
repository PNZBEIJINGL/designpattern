package com.headfirst.decorator;

/**
 * 蒸馏咖啡
 */
public class TheEspresso extends Beverage {

    public TheEspresso() {
        description = "The Espresso ";
    }

    public double cost() {
        return 1.99;
    }
}
