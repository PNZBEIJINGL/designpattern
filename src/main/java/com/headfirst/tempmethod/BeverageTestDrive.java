package com.headfirst.tempmethod;

public class BeverageTestDrive {
    public static void main(String[] args) {
        TeaWithHook teaHook = new TeaWithHook();
        CoffeeWithHook coffeeHook = new CoffeeWithHook();

        System.out.println("prepare tea");
        teaHook.prepareRecipe();

        System.out.println("prepare coffee");
        coffeeHook.prepareRecipe();
    }
}
