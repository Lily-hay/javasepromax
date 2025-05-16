package com.lily.d5_zoneidtime;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Test {
    public static void main(String[] args) {
        //高考倒计时
        String endtime="2025-06-07 09:30:00";
        DateTimeFormatter dtf=DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        LocalDateTime ldt=LocalDateTime.parse(endtime,dtf);
        LocalDateTime ldt2=LocalDateTime.now();
        Duration duration=Duration.between(ldt2,ldt);

        System.out.println(duration.toDays()+"天"+duration.toHoursPart()+"时"+duration.toSecondsPart()+"分"+duration.toMillisPart()+"秒");
    }
}
