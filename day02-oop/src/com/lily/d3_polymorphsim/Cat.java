package com.lily.d3_polymorphsim;

public class Cat extends Animal {
    String name="cat名称";
    @Override
    public void cry()
    {
        System.out.println("喵喵叫");
    }
    public void catchFish()
    {
        System.out.println("捉鱼");
    }
}
