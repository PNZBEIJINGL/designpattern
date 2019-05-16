package com.headfirst.decorator;

/**
 * 饮料
 */
public abstract class Beverage {

    String description = "Unkonw Beverage";

    public String getDescription() {
        return description;
    }

    /**
     * 价格
     *
     * @return
     */
    public abstract double cost();

}
