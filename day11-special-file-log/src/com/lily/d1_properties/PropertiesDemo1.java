package com.lily.d1_properties;

import java.io.FileInputStream;
import java.util.Properties;

public class PropertiesDemo1 {
    public static void main(String[] args) throws Exception {
        //1、创建对象
        Properties p=new Properties();
        System.out.println(p);
        //2、加载
        p.load(new FileInputStream("day11-special-file-log/src/user.properties"));
        System.out.println(p);
        //遍历
        p.forEach((k,v)->
                System.out.println(k+">>>"+v));
        System.out.println(p.getProperty("赵敏"));
    }
}
