package com.lily.d5_enum;

public enum A {
    //枚举类的第一行只能罗列一些名称，这些名称都是常量，并且每个常量记住的是枚举类的一个对象
    X,Y,Z;
    private int age;

    A(int age) {
        this.age = age;
    }

    A() {
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
