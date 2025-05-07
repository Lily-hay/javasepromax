package com.lily.extends_modifier2;

import com.lily.d9_extends_modifier.Fu;

public class Zi extends Fu {
    public void print()
    {

        //privateMethod()//报错
        //method();报错
        protectedMethod();
        publicMethod();
    }

    public static void main(String[] args) {
        Zi zi = new Zi();
        //zi.privateMethod()报错
       // zi.method();报错
        zi.protectedMethod();
        zi.publicMethod();
    }
}
