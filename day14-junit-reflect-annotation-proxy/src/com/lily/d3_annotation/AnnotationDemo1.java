package com.lily.d3_annotation;

public class AnnotationDemo1 {
    //@MyTest1(value="删除",name="lily")
    @MyTest1("删除")//自定义注解
    private String name;

    @MyTest1("删除")
    public void run()
    {

    }
    @MyTest1("删除")
    public static void main(String[] args) {

    }
}
