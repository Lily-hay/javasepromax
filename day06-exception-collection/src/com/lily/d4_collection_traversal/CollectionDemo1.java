package com.lily.d4_collection_traversal;

import java.util.ArrayList;
import java.util.Iterator;

public class CollectionDemo1 {
    public static void main(String[] args) {
        ArrayList<String> list=new ArrayList<>();
        list.add("赵敏");
        list.add("古力娜扎");
        list.add("马儿扎哈");
        System.out.println(list);

        Iterator<String> it=list.iterator();
        while(it.hasNext())
        {
            String ele=it.next();
            System.out.println(ele);
        }
    }
}
