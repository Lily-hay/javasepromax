package com.lily.d6_static_singleinstance;
/*饿汉式单例*/
public class Test2 {
    public static void main(String[] args) {
        B b1=B.getInstance();
        System.out.println(b1);
    }
}
