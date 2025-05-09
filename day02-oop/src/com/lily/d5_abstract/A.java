package com.lily.d5_abstract;

public abstract class A {
    //目标：抽象类
    private String name;
    private int age;

    public A() {
    }

    public A(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public abstract void go();//抽象方法只有方法签名，不能写方法体
    /*{

    }*/
    public abstract void run();
}
