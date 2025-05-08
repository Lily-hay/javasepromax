package com.lily.d17_this;

import com.lily.d16_extends_constuctor2.Teacher;

public class Test {
    public static void main(String[] args) {
        Student s1 = new Student("小明",18,"qinghua");
        System.out.println(s1.getName());
        System.out.println(s1.getAge());
        System.out.println(s1.getShoolName());
        Student s2=new Student("孙悟空",5000);
        System.out.println(s2.getName());
        System.out.println(s2.getAge());
        System.out.println(s2.getShoolName());

    }
}
