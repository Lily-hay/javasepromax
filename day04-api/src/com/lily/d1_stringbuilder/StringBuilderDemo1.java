package com.lily.d1_stringbuilder;

public class StringBuilderDemo1 {
    public static void main(String[] args) {
        //1、创建对象
        StringBuilder s1 = new StringBuilder("黑马");
        System.out.println(s1);

        //2、拼接内容
        s1.append("java").append(666).append("ture");
        System.out.println(s1);

        //3、反转内容
        s1.reverse();
        System.out.println(s1);

        //4、长度
        s1.length();

        //5、将StringBuilder对象转换为String对象
        //StringBuilder是拼接字符串的手段，String是开放中的目的，开放中多数要String对象来接
        String s2=s1.toString();
        System.out.println(s2);



    }
}
