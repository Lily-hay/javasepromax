package com.lily.d3_static_util;

import java.util.Random;

public class CreateCode {
    private CreateCode() {}
    public static String create(int n)
    {
        String code="";
        String s="abcdefghijklmnopqrstuvwyzABCDEFGKIGKLMNOPQRSTUVWXYZ012345789";
        Random r = new Random();
        for (int i = 0; i < n; i++) {
            int index=r.nextInt(s.length());
            char c=s.charAt(index);
            code+=c;
        }
        return code;
    }
}
