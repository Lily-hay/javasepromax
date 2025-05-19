package com.lily.d2_Lambada;

import com.lily.d1_Arrays.Student;

import java.util.Arrays;
import java.util.Comparator;

import java.util.Arrays;
import java.util.Comparator;
import java.util.function.IntToDoubleFunction;

public class LambadaTest1 {
    public static void main(String[] args) {

        double[] scores={100,78,90,98.5,88};
        //4、修改数组中每个数据并存入
        Arrays.setAll(scores, new IntToDoubleFunction() {
            @Override//匿名内部类
            public double applyAsDouble(int index) {
                return scores[index]+=10;
            }

        });
        Arrays.setAll(scores, (int index)-> {
                return scores[index]+=10;


        });//简化写法

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

        Arrays.sort(students, (Student o1, Student o2)-> {
                return Double.compare(o1.getHeight(),o2.getHeight());

        });//Lamaba表达式简化写法

        Arrays.sort(students, ( o1,  o2)-> Double.compare(o1.getHeight(),o2.getHeight()));//Lamaba表达式最终简化写法

        System.out.println(Arrays.toString(students));
    }


}
