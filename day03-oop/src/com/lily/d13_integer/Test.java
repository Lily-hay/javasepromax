package com.lily.d13_integer;

import java.sql.SQLOutput;

public class Test {
    public static void main(String[] args) {
        //认识包装类
        int a=12;
        //1、把基本类型包装为对象
        Integer it1=Integer.valueOf(a);//手动包装
        System.out.println(it1);

        //2、自动装箱机制，基本类型的对象可以直接变成对象
        Integer it2=127;
        Integer it3=127;
        System.out.println(it2==it3);//true  -128到127提供了缓存，调用的是同一个对象,超过这个范围创建的是新对象
        Integer it4=128;
        Integer it5=128;
        System.out.println(it4==it5);//false

        //3、自动拆箱机制，包装类的对象可以直接给到基本类型
        Integer it6=15;
        int b=it6;

        //Java为包装类提供了新功能
        //1、包装类可以把基本类型的数据转为字符串
        Integer it7=18;
        String rs=it7.toString();
        System.out.println(rs+2);
        //2、把字符串数据转换为对应的基本数据类型
        String re2="18.8";
        Double s=Double.parseDouble(re2);
        System.out.println(re2);
        Double d=Double.valueOf(re2);
    }
}
