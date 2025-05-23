package com.lily.d4_collection_traversal;

import java.util.ArrayList;
import java.util.Iterator;

public class CollectionDemo2 {
    public static void main(String[] args) {
        ArrayList<String> list=new ArrayList<>();
        list.add("赵敏");
        list.add("古力娜扎");
        list.add("马儿扎哈");
        System.out.println(list);

        for (String s : list) {
            System.out.println(s);
        }

        int[] ages={12,24,45,6};
        for (int age : ages) {
            System.out.println(age);

        }
    }
}
