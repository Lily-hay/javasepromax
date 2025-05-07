package com.lily.d13_extends_override2;

public class Test {
    public static void main(String[] args) {
        Student s=new Student("赵敏",18,"女","人美声甜");
        System.out.println(s);//返回地址实质是调用了object类的toString方法
        System.out.println(s.toString());
    }
}
