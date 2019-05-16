package com.headfirst.decorator;

public abstract class Beverage {

    String description="Unkonw Beverage";

    public String getDescription() {
        return description;
    }

    public abstract double cost();

}
