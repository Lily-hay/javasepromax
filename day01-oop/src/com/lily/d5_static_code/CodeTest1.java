package com.lily.d5_static_code;

import java.util.ArrayList;

public class CodeTest1 {
    public static ArrayList<String> names=new ArrayList<>();
    static{
        System.out.println("初始化执行了");//与类一同加载，只加载一次，在main方法之前，用作初始化
        names.add("张三");
        names.add("李四");
    }
    public static void main(String[] args) {
        System.out.println("main方法执行了");
    }
}
