package com.lily.d9_extends_modifier;

public class Fu {
    //private只能在本类
    private void privateMethod(){
        System.out.println("Private");
    }
    //本类、同一个包中的类
    void method(){
        System.out.println("Method");
    }
    //protected 本类、同一个包的类、子孙类（跨包时）
    protected void protectedMethod(){
        System.out.println("Protected");
    }
    //public   任意位置
    public void publicMethod(){
        System.out.println("Public");
    }

    public static void main(String[] args) {
        Fu f = new Fu();
        f.privateMethod();

    }
}
