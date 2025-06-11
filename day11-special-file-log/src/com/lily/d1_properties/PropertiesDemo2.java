package com.lily.d1_properties;

import java.io.FileOutputStream;
import java.util.Properties;

public class PropertiesDemo2 {
    public static void main(String[] args) throws Exception {
        Properties p = new Properties();
        p.setProperty("zhangsan","127369");
        p.setProperty("lisi","127369");
        p.setProperty("小昭","wuji");
        //存储
        p.store(new FileOutputStream("day11-special-file-log/src/user1.properties"),"i save some user's password ");
    }
}
