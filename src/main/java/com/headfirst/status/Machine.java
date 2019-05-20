package com.headfirst.status;

public class Machine {
    final static int SOLD_OUT = 0; //售完
    final static int NO_QUARTER = 1;  //没有25分
    final static int HAS_QUARTER = 2;  //有25分
    final static int SOLD = 3;

    int state = SOLD_OUT;
    int count = 0;

    public Machine(int count) {
        this.count = count;
        if (count > 0) {
            state = NO_QUARTER;
        }
    }

    public void insertQuarter() {
        if (state == HAS_QUARTER) {
            System.out.println("You cannt insert another quarter");
        } else if (state == NO_QUARTER) {
            state = HAS_QUARTER;
            System.out.println("You inserted a quarter");
        } else if (state == SOLD_OUT) {
            System.out.println("You inserted a quarter,but machine is sold out");
        } else {
            System.out.println("Please wait, giving you a gumball");
        }
    }
}
