package com.lily.d5_list;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ListDemo1 {
    public static void main(String[] args) {
        //1、创建一个List集合对象
        List<String> list=new ArrayList<>();//多态
        list.add("张无忌");
        list.add("小昭");
        list.add("赵敏");
        System.out.println(list);

        //2、给某个位置插入数据
        list.add(2,"小周");
        System.out.println(list);

        //3、根据索引删除数据
        System.out.println(list.remove(2));

        //4、修改索引位置数据
        list.set(2,"小花");
        System.out.println(list);

        //5、根据索引取数据
        System.out.println(list.get(1));

        //遍历
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
        Iterator<String> iterator = list.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }

    }



}
