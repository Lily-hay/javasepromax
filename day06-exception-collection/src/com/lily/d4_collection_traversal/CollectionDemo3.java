package com.lily.d4_collection_traversal;

import java.util.ArrayList;
import java.util.function.Consumer;

public class CollectionDemo3 {
    public static void main(String[] args) {
        ArrayList<String> list=new ArrayList<>();
        list.add("赵敏");
        list.add("古力娜扎");
        list.add("马儿扎哈");
        System.out.println(list);

        list.forEach(new Consumer<String>() {

            @Override
            public void accept(String s) {
                System.out.println(s);
            }
        });

        list.forEach(( s)->System.out.println(s));

        list.forEach(System.out::println);
    }
}
