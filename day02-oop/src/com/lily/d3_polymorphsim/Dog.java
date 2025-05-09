package com.lily.d3_polymorphsim;

public class Dog extends Animal {
    String name="dog名称";
    @Override
    public void cry(){
        System.out.println("汪汪叫");
    }
    public void lookdoor()
    {
        System.out.println("狗狗看门");
    }
}
