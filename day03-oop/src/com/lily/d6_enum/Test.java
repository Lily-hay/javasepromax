package com.lily.d6_enum;

public class Test {
    //枚举的应用场景
    public static void main(String[] args) {
        System.out.println(handleData(3.46677, Constant2.HALF_UP));

    }
    public static double handleData(double number,Constant2 flag)
    {
        switch(flag) {
            case Constant2.DOWN:
                number=Math.floor(number);
                break;
            case UP:  // 还支持这样
                number=Math.ceil(number);
                break;
            case Constant2.HALF_UP:
                number=Math.round(number);
                break;
            case Constant2.DELETE_LEFT:
                number=(int) number;
                break;
        }
        return number;
    }
}
