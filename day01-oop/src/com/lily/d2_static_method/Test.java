package com.lily.d2_static_method;

public class Test {
    public static void main(String[] args) {
        Student s1 = new Student();
        Student.printHelloWorld();//静态方法，通过类名直接访问
        s1.printHelloWorld();//也可用对象访问，不推荐
        Student s2 = new Student();
        s2.score=70;
        s2.pass();//实例方法，只可通过对象访问

    }
}
