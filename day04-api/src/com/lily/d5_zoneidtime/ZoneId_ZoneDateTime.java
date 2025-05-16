package com.lily.d5_zoneidtime;

import java.time.Clock;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Set;

public class ZoneId_ZoneDateTime {
    public static void main(String[] args) {
        ZoneId zoneid=ZoneId.systemDefault();
        System.out.println(zoneid);
        System.out.println(zoneid.getId());//得到id
        System.out.println(zoneid.toString());//得到id

        Set<String> availableZoneIds = ZoneId.getAvailableZoneIds();//所有时区
        System.out.println(availableZoneIds);

        ZoneId an=ZoneId.of("America/Cuiaba");
        ZonedDateTime dt=ZonedDateTime.now(an);//拿到时间

        System.out.println(dt);

        ZonedDateTime st=ZonedDateTime.now(Clock.systemDefaultZone());//拿到世界标准时间
        System.out.println(st);
    }
}
