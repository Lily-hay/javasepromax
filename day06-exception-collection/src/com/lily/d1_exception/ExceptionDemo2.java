package com.lily.d1_exception;

public class ExceptionDemo2 {
    public static void main(String[] args) {
        save(200);

    }
    public static void save(int age)
    {
        if(age<0||age>150)
        {
            throw new AgeIllegalRuntimeException("/age is wrong");
        }
        System.out.println("年龄保存成功！");
    }
}
