package com.lily.static_field;
/*stati的用法*/
public class Test {
    public static void main(String[] args) {
        //静态变量可用类直接访问
        Student.name="小明";
        System.out.println(Student.name);
        //不推荐用对象访问
        Student s1=new Student();
        s1.name="小红";
        System.out.println(s1.name);
        Student s2=new Student();
        s2.name="小张";
        System.out.println(s1.name);//由于地址只有一份，结果为小张

        //实例变由对象访问，修改值各不影响
        s1.age=18;
        s2.age=24;
        System.out.println(s1.age);//结果为18
    }
}
