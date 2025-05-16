package com.lily.d4_bigdecimal;

import java.math.BigDecimal;

public class BigDecimalDemo1 {
    public static void main(String[] args) {
        double a=0.1;
        double b=0.2;
        //直接计算
        double c=a+b;
        System.out.println(c);//0.30000000000000004精度失真

        //1、创建对象
        BigDecimal a1=new BigDecimal(Double.toString(a));
        BigDecimal b1=new BigDecimal(Double.toString(b));

        //2、用BigDecimal作为手段计算
        BigDecimal c1=a1.add(b1);

        //3、返回double
        double c11=c1.doubleValue();
        System.out.println(c11);


    }
}
