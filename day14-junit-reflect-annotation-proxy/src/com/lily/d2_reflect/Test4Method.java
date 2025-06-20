package com.lily.d2_reflect;

import org.junit.Test;

import javax.crypto.spec.PSource;
import java.lang.reflect.Method;

public class Test4Method {
    @Test
    public void testMethods() throws Exception {
        Class c=Cat.class;
        Method[] methods=c.getDeclaredMethods();
        //获取所有方法
        for (Method method : methods) {
            System.out.println(method.getName()+">>>"+method.getParameterCount());
        }

        //获取单个方法
        Method eat1=c.getDeclaredMethod("eat");
        Method eat2=c.getDeclaredMethod("eat",String.class);

        //获取方法的目的，执行
        Cat cat=new Cat();
        Object result = eat1.invoke(cat);
        System.out.println(result);
        eat2.setAccessible(true);//暴力反射
        Object result2 = eat2.invoke(cat,"鱼儿");
        System.out.println(result2);


    }
}
