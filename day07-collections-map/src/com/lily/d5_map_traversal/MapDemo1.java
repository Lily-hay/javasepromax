package com.lily.d5_map_traversal;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class MapDemo1 {
    public static void main(String[] args) {
        //遍历方式
        //1、键找值
        Map<String,Integer> map = new HashMap<>();
        map.put("Java入门",1);
        map.put("iphone16",1);
        map.put("小米",5);
        map.put("布偶",2);
        map.put("华为",10);
        Set<String> keys = map.keySet();
        for (String key : keys) {
            int value = map.get(key);
            System.out.println(key + ":" + value);
        }

        //2、键值对,先将Map集合转为Set集合，将键值封装成一个整体的Entray对象
        Set<Map.Entry<String,Integer>> entries = map.entrySet();
        for (Map.Entry<String, Integer> entry : entries) {
            String key=entry.getKey();
            int value=entry.getValue();
            System.out.println(key + ":" + value);
        }

        //3、Lambda
       /* map.forEach(new BiConsumer<String, Integer>() {
            @Override
            public void accept(String key, Integer value) {
                System.out.println(key + ">>>" + value);
            }
        });*/
        map.forEach((k,v)->{
            System.out.println(k + ">>>" + v);
        });
    }
}
