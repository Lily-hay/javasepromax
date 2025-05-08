package com.lily.d1_polymorphism;

public class Cat extends Animal {
    String name="cat名称";
    @Override
    public void cry()
    {
        System.out.println("喵喵叫");
    }
}
