package com.lily.d5_enum;

public class Test {
    public static void main(String[] args) {
        //构造器私有，枚举类，不能对外构建对象
        //A a=new A();报错
        A a1=A.X;
        A a2=A.Y;
        System.out.println(a1); //X，重写了toString方法
        System.out.println(a2);
        A[] a=A.values();
        for (int i = 0; i < a.length; i++) {
            A as=a[i];
            System.out.println("=========");
            System.out.println(as);
            System.out.println("==========");
        }
        A a3=A.valueOf("z");
        System.out.println(a3);
    }
}
