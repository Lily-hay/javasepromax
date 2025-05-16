package com.lily.d5_zoneidtime;

import java.time.Duration;
import java.time.LocalDateTime;

public class DurationDemo {
    public static void main(String[] args) {
        LocalDateTime start=LocalDateTime.of(2025,3,20,12,28,10);
        LocalDateTime end=LocalDateTime.of(2025,3,20,12,29,11);
        //1、得到Duration对象
        Duration duration= Duration.between(start,end);
        //2、计算两个时间间隔
        System.out.println(duration.toDays());
        System.out.println(duration.toHours());
        System.out.println(duration.toMinutes());
        System.out.println(duration.toMillis());
        System.out.println(duration.toSeconds());
        System.out.println(duration.toMillis());
        System.out.println(duration.toNanos());
    }
}
