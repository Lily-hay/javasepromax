package d1_stream;

import java.util.*;
import java.util.stream.Stream;

public class StreamDemo1 {
    public static void main(String[] args) {
        //1、获取集合的Stream流
        Collection<String> list= new ArrayList<>();
        Collections.addAll(list,"张无忌","赵敏","周芷若","张强","张三丰");
        Stream<String> s1=list.stream();
        System.out.println(s1.count());
        
        //2、获取Map集合的Stream流
        Map<String,Integer> map=new HashMap<>();
        //获取键流  
        Stream<String> s2=map.keySet().stream();
        //获取值流
        Stream<Integer> s3=map.values().stream();
        //获取键值对流
        Stream<Map.Entry<String,Integer>> kv=map.entrySet().stream();
        
        //3、获取数据的Stream流
        String[] names={"赵敏","周芷若","张强","张三丰"};
        Stream<String> as = Arrays.stream(names);
        Stream.of(names);


    }
}
