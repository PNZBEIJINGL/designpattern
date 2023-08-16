package com.headfirst.singleton;

import com.thread.premessage.Helper;

public class Foo {

    private Helper helper = null;
    public Helper getHelper() {
        if (helper == null)
            synchronized(this) {
                if (helper == null)
                    helper = new Helper();
            }
        return helper;
    }
    // other functions and members...
}
