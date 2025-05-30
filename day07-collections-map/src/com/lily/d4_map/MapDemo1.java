package com.lily.d4_map;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class MapDemo1 {
    public static void main(String[] args) {
        Map<String,Integer> map = new HashMap<>();
        map.put("Java入门",1);
        map.put("iphone16pro",1);
        map.put("xiaomi15",5);
        map.put("doal",2);
        map.put("xiaomi15",10);
        System.out.println(map);
        //1、获取集合长度
        System.out.println(map.size());

        //2、清空集合
        /*map.clear();
        System.out.println(map);*/

        //3、格局键获取相应的值
        System.out.println(map.get("xiaomi15"));
        map.get("xiaomi");

        //4、根据键删除整个数据，返回被删除对象对应的值
        System.out.println(map.remove("xiaomi15"));
        System.out.println(map);

        //5、判断键是否包含某个值
        System.out.println(map.containsKey("xiaomi15"));
        System.out.println(map.containsKey("doal"));

        //6、判断值包含某个值
        System.out.println(map.containsValue(1));
        System.out.println(map.containsValue(2));

        //7、判断集合是否为空
        System.out.println(map.isEmpty());

        //8、获取Map的全部键，到一个Set集合
        Set<String> keys=map.keySet();
        System.out.println(keys);

        //9、获取Map的所有值到一个Collection集合
        Collection<Integer> values=map.values();
        System.out.println(values);
    }
}
