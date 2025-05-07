package com.lily.d9_extends_modifier;

public class Demo1 {
    public static void main(String[] args) {
        Fu f = new Fu();
        //f.privateMethod报错
        f.method();
        f.protectedMethod();
        f.publicMethod();
    }
}
