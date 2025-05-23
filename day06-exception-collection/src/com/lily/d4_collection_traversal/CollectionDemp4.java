package com.lily.d4_collection_traversal;

import java.util.ArrayList;
import java.util.Iterator;

public class CollectionDemp4 {
    public static void main(String[] args) {
        ArrayList<String> list1=new ArrayList<>();
        list1.add("java入门");
        list1.add("宁夏枸杞");
        list1.add("黑枸杞");
        list1.add("人字拖");
        list1.add("特技枸杞");
        list1.add("枸杞子");
        System.out.println(list1);

        Iterator<String> it=list1.iterator();
        while(it.hasNext()){
            String ele=it.next();
            if(ele.contains("枸杞"))
            {
                it.remove();
            }
        }
        System.out.println(list1);
    }
}
