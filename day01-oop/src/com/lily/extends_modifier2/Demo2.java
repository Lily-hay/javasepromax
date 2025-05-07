package com.lily.extends_modifier2;

import com.lily.d9_extends_modifier.Fu;

public class Demo2 {

    public static void main(String[] args) {
        Fu f = new Fu();
        //f.privateMethod()报错
        //f.method();报错
        //f.protectedMethod();报错
        f.publicMethod();
    }

}
