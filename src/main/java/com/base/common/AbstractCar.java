package com.base.common;

public class AbstractCar {
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void changeName(String name){
        setName(name);
    }

    public static void main(String[] args) {

        AbstractCar car1=new GreenCard();
        car1.setName("car1");
        AbstractCar car2=new BlueCard();
        car2.setName("car2");

        System.out.println(car1.getName());
        System.out.println(car2.getName());
        car1.changeName("xxxx");

        System.out.println(car1.getName());
        System.out.println(car2.getName());


    }
}
