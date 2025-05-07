package com.lily.d7_extends;

public class Test {
    public static void main(String[] args) {
        B b=new B();//子类对象创建的特点：会由子类·和父类多张设计图共同创建，但能访问什么还是要看权限，后续可用get,set方法访问私有成员
        //System.out.println(b.k);报错
        System.out.println(b.i);
        //System.out.println(b.j);报错
        b.print1();
        b.print3();
    }

}
