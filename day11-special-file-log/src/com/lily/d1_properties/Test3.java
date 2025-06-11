package com.lily.d1_properties;

import java.io.FileReader;
import java.io.FileWriter;
import java.util.Properties;

public class Test3 {
    public static void main(String[] args) throws Exception {
        Properties p=new Properties();
        p.load(new FileReader("day11-special-file-log/src/people.txt"));
        if(p.containsKey("李芳"))
        {
            p.setProperty("李芳","18");
        }
        p.store(new FileWriter("day11-special-file-log/src/people.txt"),"change message");
        System.out.println(p);
    }
}
