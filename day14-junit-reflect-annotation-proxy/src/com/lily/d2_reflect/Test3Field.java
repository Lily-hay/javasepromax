package com.lily.d2_reflect;

import org.junit.Test;

import javax.crypto.spec.PSource;
import java.lang.reflect.Field;

public class Test3Field {
    @Test
    public void testGetFields() throws Exception {
        Class c=Cat.class;
        //获取全部对象
        Field[] fields=c.getDeclaredFields();
        for (Field field : fields) {
            System.out.println(field.getType()+">>>"+field.getName());
        }

        //获取单个对象
        Field fname=c.getDeclaredField("name");

        //获取成员变量的作用依然是赋值、取值
        fname.setAccessible(true);//暴力反射
        Cat cat=new Cat();
        fname.set(cat,"哆啦A梦");
        String name = (String)fname.get(cat);
        System.out.println(name);

    }
}
