package com.lily.d5_map_traversal;

import java.util.*;

public class MapTest {
    public static void main(String[] args) {
        String[] locations={"玉龙雪山","伶仃岛","泰国","三亚"};
        List<String> data=new ArrayList<>();
        Random r=new Random();
        for (int i = 0; i < 80; i++) {
            data.add(locations[r.nextInt(locations.length)]);
        }
        Map<String,Integer> map=new HashMap<>();
        for (String k : data) {
            if(map.containsKey(k)){
                map.put(k,map.get(k)+1);
            }
            else {
                map.put(k,1);
            }
        }
        map.forEach((k,v)->{
            System.out.println(k+"选择人数:"+v);
        });
    }
}
