package com.lily.d5_static_code;

public class CodeTest2 {
    {
        System.out.println("实例代码块执行了");
    }
    public CodeTest2() {
        System.out.println("=====构造器实行了====");
    }

    public static void main(String[] args) {
        CodeTest2 t = new CodeTest2();
    }
}
