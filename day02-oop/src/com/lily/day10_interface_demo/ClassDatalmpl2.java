package com.lily.day10_interface_demo;

import java.util.ArrayList;

public class ClassDatalmpl2 implements ClassData{
    ArrayList<Student> students=new ArrayList<>();

    public ClassDatalmpl2() {
    }

    public ClassDatalmpl2(ArrayList<Student> students) {
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
        Student s1=students.get(0);
        double min=s1.getScore();
        double max=s1.getScore();
        for (int i = 0; i < students.size(); i++) {
            Student s=students.get(i);
            score+=s.getScore();
            if(max<s.getScore()) {max=s.getScore();}
            if(min>s.getScore()){min=s.getScore();}
        }
        System.out.println("最高分："+max);
        System.out.println("最低分："+min);
        System.out.println("平均分："+(score-min-max)/(students.size()-2));
    }
}
