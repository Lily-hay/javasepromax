package com.lily.d3_collection_api;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

public class CollectionAPIDemo1 {
    public static void main(String[] args) {
        Collection<String> list=new ArrayList<>();//多态用法
        //1、添加
        list.add("张无忌");
        list.add("张无忌");
        list.add("朱九真");
        list.add("周芷若");
        list.add("java1");
        list.add("周芷若");
        list.add("小昭");
        System.out.println(list);

        //2、清空集合
        //list.clear();
        //System.out.println(list);

        //3、判断集合是否为空
        System.out.println(list.isEmpty());

        //4、直接删除集合中某个元素
        System.out.println(list.remove("张无忌"));
        System.out.println(list);

        //5、判断是否包含某个数据
        System.out.println(list.contains("java1"));

        //6、获取集合的大小
        System.out.println(list.size());

        //7、把集合转为数组
        Object[] array=list.toArray();//防止有其他类型的数据
        System.out.println(Arrays.toString(array));
        //拓展
        String[] array1=list.toArray(String[]::new);
        System.out.println(Arrays.toString(array1));

        //拓展，将别人集合加到自己这里
        Collection<String> c1=new ArrayList<>();
        c1.add("java1");
        c1.add("java2");
        Collection<String> c2=new ArrayList<>();
        c2.add("java2");
        c2.add("java3");
        c1.addAll(c2);
        System.out.println(c1);



    }
}
