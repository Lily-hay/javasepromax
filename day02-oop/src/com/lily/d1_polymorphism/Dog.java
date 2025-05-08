package com.lily.d1_polymorphism;

public class Dog extends Animal{
    String name="dog名称";
    @Override
    public void cry(){
        System.out.println("汪汪叫");
    }
}
