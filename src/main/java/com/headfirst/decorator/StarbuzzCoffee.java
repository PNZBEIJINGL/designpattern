package com.headfirst.decorator;

public class StarbuzzCoffee {

    public static void main(String[] args){
        Beverage espresso=new Espresso();
        System.out.println(espresso.getDescription()+"$"+espresso.cost());

        Beverage darkRoast=new TheDarkRoast();
        darkRoast=new Mocha(darkRoast);
        darkRoast=new Whip(darkRoast);
        System.out.println(darkRoast.getDescription()+"$"+darkRoast.cost());

        Beverage houseBlend=new TheHouseBlend();
        houseBlend=new Mocha(houseBlend);
        houseBlend=new Whip(houseBlend);
        houseBlend=new Milk(houseBlend);
        System.out.println(houseBlend.getDescription()+"$"+houseBlend.cost());

    }
}
