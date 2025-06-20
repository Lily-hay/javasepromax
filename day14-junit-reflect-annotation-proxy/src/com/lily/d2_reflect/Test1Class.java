package com.lily.d2_reflect;

public class Test1Class {
    public static void main(String[] args) throws Exception {
        //反射第一步：获取Class对象
        //1方式一，类名.class
        Class c1=Student.class;
        System.out.println(c1);

        //2方式二，对象.getClass()
        Student s=new Student();
        Class c2=s.getClass();
        System.out.println(c2);

        //方式三，Class.forName(全类名)
        Class c3=Class.forName("com.lily.d2_reflect.Student");
        System.out.println(c3);
    }
}
