package com.lily.d1_stream;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamDemo3 {
    public static void main(String[] args) {
        List<String> list=new ArrayList<>();
        Collections.addAll(list,"张无忌","赵敏","周芷若","张强","张三丰","张三丰");
        Stream<String> s1=list.stream();//流只能用一次
        //1、收到list集合
        List<String> newlist=s1.filter(s->s.startsWith("张")&&s.length()==3).collect(Collectors.toList());
        System.out.println(newlist);

        //2、收集到Set集合
        Stream<String> s2 = list.stream();
        Set<String> set = s2.filter(s -> s.startsWith("张")).collect(Collectors.toSet());
        System.out.println(set);

        //3、收集到数组
        Stream<String> s3= list.stream();
        Object[] objects = s3.filter(s -> s.startsWith("张")).toArray();
        System.out.println(Arrays.toString(objects));

        //4、收集到Map集合
        List<Movie> movies=new ArrayList<>();
        Movie m1=new Movie("三傻大闹宝莱坞",8.8,"阿米尔汗2");
        Movie m3=new Movie("三傻大闹宝莱坞",8.9,"阿米尔汗2");
        Movie m2=new Movie("摔跤吧，爸爸",9.5,"阿米尔汗");
        Movie m4=new Movie("阿甘正传",7.5,"汤姆汉克斯");
        Collections.addAll(movies,m1,m2,m3,m4);
        //报错Duplicate key，二分合并
        Map<String,Double> map= movies.stream().limit(3).collect(Collectors.toMap(m11->m11.getName(),m22->m22.getScore(),(v1,v2)->v2));
        System.out.println(map);

    }
}
