package com.lily.d7_TreeSet;

import java.util.Comparator;
import java.util.TreeSet;

public class Test {
    public static void main(String[] args) {
        TreeSet ts = new TreeSet();
        Student s1 = new Student("赵敏",38,167);
        Student s2 = new Student("菲菲",25,168.5);
        Student s3 = new Student("米克",18,165);
        Student s4= new Student("红红",25,168.5);
        ts.add(s1);
        ts.add(s2);
        ts.add(s3);
        ts.add(s4);
        System.out.println(ts);

    }
}
