package com.lily.day10_interface_demo;

import java.util.ArrayList;

public class ClassDatalmpl1 implements ClassData{
    ArrayList<Student> students=new ArrayList<>();

    public ClassDatalmpl1() {
    }

    public ClassDatalmpl1(ArrayList<Student> students) {
        this.students = students;
    }

    @Override
    public void printAllStudentDataInfo() {
        for (int i = 0; i < students.size(); i++) {
            Student s=students.get(i);
            System.out.println(s.getName()+" "+s.getSex()+" "+s.getScore());
        }

    }

    @Override
    public void printAllStudentScore() {
        double score=0;
        for (int i = 0; i < students.size(); i++) {
            Student s=students.get(i);
            score+=s.getScore();
        }
        System.out.println("平均分："+score/students.size());
    }
}
