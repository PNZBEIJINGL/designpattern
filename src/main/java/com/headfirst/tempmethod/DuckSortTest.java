package com.headfirst.tempmethod;

import java.util.Arrays;

public class DuckSortTest {
    public static void main(String[] args) {
        Duck[] ducks = new Duck[]{
                new Duck("Alic", 8),
                new Duck("Mac", 7),
                new Duck("Liu", 2),
                new Duck("Alic", 9)
        };

        System.out.println("=====begin=====");
        display(ducks);

        Arrays.sort(ducks);
        System.out.println("======end======");
        display(ducks);

    }

    private static void display(Duck[] ducks) {
        for (int i = 0; i < ducks.length; i++) {
            System.out.println(ducks[i]);
        }
    }
}
