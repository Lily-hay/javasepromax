package com.lily.d2_collections;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CollectionsTest1 {
    public static void main(String[] args) {
        //Collections的其他用法
        List<String> names=new ArrayList<>();
        //1、
        Collections.addAll(names,"张无忌","小张","赵敏");

        //2、
        Collections.shuffle(names);
        System.out.println(names);

        //3、
        List<Student> list=new ArrayList<>();
        Student s1 = new Student("赵敏",38,167);
        Student s2 = new Student("菲菲",25,168.5);
        Student s3 = new Student("米克",18,165);
        Student s4= new Student("红红",25,168.5);
        Collections.addAll(list,s1,s2,s3,s4);

        Collections.sort(list,((o1,o2)->Double.compare(o1.getHeight(),o2.getHeight())));
        System.out.println(list.toString());

    }
}
