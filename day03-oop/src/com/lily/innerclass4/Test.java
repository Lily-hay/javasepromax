package com.lily.innerclass4;

public class Test {
    public static void main(String[] args) {
        Animal a=new Animal()//匿名内部类
        {
            @Override
            public void cry() {
                System.out.println("狗汪汪叫---");
            }
        };
        a.cry();
    }
}
abstract class Animal
{
    public abstract void cry();
}