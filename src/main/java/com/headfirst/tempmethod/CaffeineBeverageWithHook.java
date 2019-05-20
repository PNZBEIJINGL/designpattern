package com.headfirst.tempmethod;

public abstract class CaffeineBeverageWithHook {

    void prepareRecipe() {
        boilWater();
        brew();
        pourInCup();
        if (customerWantCondiments()) {
            addCondiments();
        }
    }

    protected void addCondiments() {

    }

    protected void pourInCup() {
        System.out.println("Pouring into cup");
    }


    protected void brew() {

    }

    protected void boilWater() {
        System.out.println("Boil Water");

    }

    protected boolean customerWantCondiments() {
        return true;
    }

}
