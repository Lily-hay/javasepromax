package com.lily.d4_final;

public class FinalDemo1 {
    public static final String SCHOOL_NAME="黑马";//常量
    public static final String SCHOOL_NAME2;//常量
    static{
        SCHOOL_NAME2="黑马程序员";
    }
    public static void main(String[] args) {
        //final String schoolName="黑马程序员";

        //schoolName="黑马";报错，final修饰，该变量只能被赋值一次
        //final的用法
        //java的变量
        /*
        1、局部变量：方法、形参、for循环、构造器类的
        2、成员变量：
           实例
           静态
        */
    }
    final class A{

    }
    //class B extends A{}报错，final修饰的类不可以被继承
    class C{
        public final void run()
        {
            System.out.println("跑~~~~");
        }
    }
    class D extends C{
       // @Override报错，最终方法，该方法不可以被重写
       /* public void run()
        {
            System.out.println("跑~~~~");
        }*/
    }

}
