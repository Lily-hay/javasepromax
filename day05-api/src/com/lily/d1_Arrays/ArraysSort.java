package com.lily.d1_Arrays;

import java.util.Arrays;
import java.util.Comparator;

public class ArraysSort {
    public static void main(String[] args) {
        Student[] students=new Student[4];
        students[0]=new Student("小红",18,"女",160);
        students[1]=new Student("小华",30,"女",158);
        students[2]=new Student("小明",20,"男",179.5);
        students[3]=new Student("小开",25,"男",175);
        Arrays.sort(students);
        System.out.println(Arrays.toString(students));

        Arrays.sort(students, new Comparator<Student>() {
            @Override
            public int compare(Student o1, Student o2) {
                /*if(o1.getHeight()> o2.getHeight())
                    return 1;
                else if(o1.getHeight()<o2.getHeight())
                    return -1;
                return 0;*/
                return Double.compare(o1.getHeight(),o2.getHeight());
            }
        });

        System.out.println(Arrays.toString(students));
    }


}
