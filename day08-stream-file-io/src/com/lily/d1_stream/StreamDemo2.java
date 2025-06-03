package com.lily.d1_stream;

import java.util.*;
import java.util.stream.Stream;

public class StreamDemo2 {
    public static void main(String[] args) {
        //1、过滤集合
        Collection<String> list= new ArrayList<>();
        Collections.addAll(list,"张无忌","赵敏","周芷若","张强","张三丰");
        list.stream().filter(s->s.startsWith("张")).filter(s->s.length()==3).forEach(System.out::println);

        //2、排序
        List<Movie> movies=new ArrayList<>();
        Movie m1=new Movie("三傻大闹宝莱坞",8.8,"阿米尔汗2");
        Movie m3=new Movie("三傻大闹宝莱坞",8.8,"阿米尔汗2");
        Movie m2=new Movie("摔跤吧，爸爸",9.5,"阿米尔汗");
        Movie m4=new Movie("阿甘正传",7.5,"汤姆汉克斯");
        Collections.addAll(movies,m1,m2,m3,m4);
        movies.stream().sorted((o1,o2)->Double.compare(o1.getScore(),o2.getScore())).forEach(System.out::println);

        //3、limit取几个
        System.out.println("===================");
        movies.stream().limit(3).forEach(System.out::println);

        //4、skip跳过前几个
        System.out.println("===========================");
        movies.stream().skip(3).forEach(System.out::println);

        //5、distinct去重,要求重写equals,hashCode方法
        System.out.println("==============================");
        movies.stream().distinct().forEach(System.out::println);

        //6、map加工方法，将流上的数据加工成新数据
        System.out.println("=============================");
        movies.stream().map(m->m.getName()+"====>"+m.getScore()).forEach(System.out::println);

        //7、合并流，同一类型的流或者接受数据变成泛型
        Stream<String> s1=Stream.of("张三","楚留香","西门吹牛");
        Stream<String> s2 = Stream.of("李四", "石观音");
        Stream<String> s = Stream.concat(s1, s2);
        System.out.println(s.count());

        Optional<Movie> max = movies.stream().max((o1, o2) -> Double.compare(o1.getScore(), o2.getScore()));
        System.out.println(max);

    }

}
