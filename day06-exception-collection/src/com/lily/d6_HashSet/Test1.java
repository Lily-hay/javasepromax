package com.lily.d6_HashSet;

import java.util.HashSet;
import java.util.Set;

public class Test1 {
    public static void main(String[] args) {
        Set sets = new HashSet();
        Student s1 = new Student("张继科","男","乒乓");
        Student s2 = new Student("林丹","男","羽毛球");
        Student s3 = new Student("景甜","女","张");
        Student s4= new Student("景甜","女","张");
        sets.add(s1);
        sets.add(s2);
        sets.add(s3);
        sets.add(s4);
        System.out.println(sets);
    }
}
