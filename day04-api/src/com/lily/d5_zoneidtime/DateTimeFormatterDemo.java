package com.lily.d5_zoneidtime;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class DateTimeFormatterDemo {
    public static void main(String[] args) {
        DateTimeFormatter dtf=DateTimeFormatter.ofPattern("yyyy年MM月dd日 HH:mm:ss EEE a");
        LocalDateTime ldt=LocalDateTime.now();
        System.out.println(ldt);
        String result=ldt.format(dtf);
        System.out.println(result);
        //另一种写法
        String result2=dtf.format(ldt);
        System.out.println(result2);

        //其他时间格式转换
        String datetime="2025-11-16 12:12:12";
        DateTimeFormatter dtf2=DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        LocalDateTime ldt2=LocalDateTime.parse(datetime,dtf2);
        System.out.println(ldt2);
    }
}
