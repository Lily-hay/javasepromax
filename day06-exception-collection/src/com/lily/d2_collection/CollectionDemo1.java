package com.lily.d2_collection;

import java.util.ArrayList;
import java.util.HashSet;

public class CollectionDemo1 {
    public static void main(String[] args) {
        //ArrayList集合对象：有序，可重复，有索引
        ArrayList<String> list=new ArrayList<>();
        list.add("张无忌");
        list.add("张无忌");
        list.add("朱九真");
        list.add("周芷若");
        list.add("周芷若");
        list.add("小昭");
        System.out.println(list);
        System.out.println(list.get(2));
        //Set集合：无序、不能重复、无索引
        HashSet<String> set=new HashSet<>();
        set.add("张无忌");
        set.add("张无忌");
        set.add("朱九真");
        set.add("周芷若");
        set.add("周芷若");
        set.add("小昭");
        System.out.println(set);
        //System.out.println(set.get(2));


    }
}
