package com.lily.d9_interface;

public class Test {
    public static void main(String[] args) {
        //接口的好处
        //1、弥补了类单继承的不足
        People p = new Student();
        Driver d=new Student();//多态
        Doctor d1=new Student();

        //2、让程序面向接口编程，可以方便灵活的切换各种业务实现
        Driver d2=new Teacher();
        Driver d3=new Student();
    }
}
