package com.headfirst.tempmethod;

public class TeaWithHook extends CaffeineBeverageWithHook {

    protected void prepareRecipe() {
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
        System.out.println("brew");
    }

    protected void boilWater() {
        System.out.println("Boil Water");

    }

    protected boolean customerWantCondiments() {

        return false;
    }

}
