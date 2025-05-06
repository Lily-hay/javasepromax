package com.lily.d2_static_method;

public class Student {
    double score;
    public static void printHelloWorld()
    {
        System.out.println("Hello World");
        System.out.println("Hello World");
        System.out.println("Hello World");
    }
    public void pass()
    {
        System.out.println(score>=60?"通过":"挂科");
    }
}
