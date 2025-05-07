package com.lily.d7_extends;

public class B extends A {
    private int k;
    public void print3(){
        System.out.println("B print3");
        print1();
        System.out.println(i);
//        print2();报错，子类只可继承父类非私有成员
//        System.out.println(j);//报错
        System.out.println(getJ());

    }


}
