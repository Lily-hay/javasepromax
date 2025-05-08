package com.lily.d1_polymorphism;

public class Test {
    public static void main(String[] args) {
        Animal a1=new Cat();//编译看左，运行看右
        a1.cry();
        Animal a2=new Dog();//编译看左，运行看右
        a2.cry();
        System.out.println(a1.name);//成员变量没有多态
        System.out.println(a2.name);
    }
}
