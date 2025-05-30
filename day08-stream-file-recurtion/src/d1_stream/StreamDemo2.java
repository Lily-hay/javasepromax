package d1_stream;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

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

    }

}
