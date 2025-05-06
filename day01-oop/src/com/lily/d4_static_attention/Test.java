package com.lily.d4_static_attention;

public class Test {
    public static String schoolName="西电";
    private String name;
    public static void printName()
    {
        System.out.println(schoolName);
    }
    public void printInfo()
    {
        System.out.println("名字叫："+name);
    }
    public static void main(String[] args) {
        Test.testStatic();
        Test t=new Test();
        t.testNostatic();
    }
    public void testNostatic()
    {
        //2、实例方法中，可以直接访问静态成员，也可以直接访问实例成员
        System.out.println(schoolName);
        printName();
        printInfo();
        System.out.println(this);
        //3、静态方法中，不可出现this,实例方法可以
    }
    public static void testStatic()
    {
        //1、静态方法中，可以直接访问类的静态成员，不能直接访问实例成员
        System.out.println(schoolName);
        printName();
        //printInfo();报错
        //System.out.println(name);报错
        //System.out.println(this);静态方法中，不可出现this
    }
}
