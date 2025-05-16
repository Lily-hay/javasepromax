package com.lily.d5_zoneidtime;

import java.time.Instant;

public class InstantDemo {
    public static void main(String[] args) {
        Instant now= Instant.now();
        System.out.println(now);
        System.out.println(now.getEpochSecond());

        System.out.println(now.getNano());
    }
}
