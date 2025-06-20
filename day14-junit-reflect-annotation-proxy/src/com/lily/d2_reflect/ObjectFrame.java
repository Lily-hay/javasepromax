package com.lily.d2_reflect;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.lang.reflect.Field;

public class ObjectFrame {
    public static void saveObject(Object obj) throws Exception {
        //获取对象中的全部字段，对象中有多少个字段，我们不清楚，但反射可以解决
        PrintWriter pw=new PrintWriter(new FileWriter("day14-junit-reflect-annotation-proxy/src/obj.txt"));
        Class c=obj.getClass();
        String className=c.getSimpleName();//Student
        System.out.println(className);
        pw.println("~~~~~~~~~~~"+className+"~~~~~~~~~~");
        Field[] fields=c.getDeclaredFields();
        for (Field field : fields) {
            String name=field.getName();
            field.setAccessible(true);
            String value=field.get(obj)+"";
            pw.println(name+"="+value);
            System.out.println(name+"="+value);
        }
        pw.close();
    }
}
