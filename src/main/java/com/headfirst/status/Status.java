package com.headfirst.status;

public class Status {
    final static int SOLD_OUT = 0; //售完
    final static int NO_QUARTER = 1;  //没有25分
    final static int HAS_QUARTER = 2;  //有25分
    final static int SOLD = 3;

    int state = SOLD_OUT;
}
