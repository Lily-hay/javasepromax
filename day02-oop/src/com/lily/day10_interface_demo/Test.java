package com.lily.day10_interface_demo;

import java.util.ArrayList;

public class Test {
    public static void main(String[] args) {
        ArrayList<Student> students=new ArrayList<>();
        students.add(new Student("张三","男",88));
        students.add(new Student("李四","男",58));
        students.add(new Student("王五","男",76));
        students.add(new Student("小红","女",96));
        students.add(new Student("小芳","女",90));
        ClassData c=new ClassDatalmpl2(students);
        c.printAllStudentDataInfo();
        c.printAllStudentScore();

    }
}
