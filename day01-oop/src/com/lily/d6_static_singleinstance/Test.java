package com.lily.d6_static_singleinstance;
/*单例设计模式*/
public class Test {
    public static void main(String[] args) {
        A a1=A.getInstance();
        A a2=A.getInstance();
        System.out.println(a1);
        System.out.println(a2);
    }
}
