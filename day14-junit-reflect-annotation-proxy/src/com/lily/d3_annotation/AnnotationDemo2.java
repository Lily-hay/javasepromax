package com.lily.d3_annotation;

import org.junit.Test;

import java.lang.reflect.Method;

public class AnnotationDemo2 {
    @Test
    public void parseClass() throws Exception {
        Class c=Demo.class;//先得到该类
        Method method=c.getDeclaredMethod("test1");
        if(c.isAnnotationPresent(MyTest4.class))//再判断该类上有没有注解
        {
            MyTest4 myTest4= (MyTest4) c.getDeclaredAnnotation(MyTest4.class);
            System.out.println(myTest4.value());
            System.out.println(myTest4.aaa());
            System.out.println(myTest4.bbb());

        }
    }

}
@MyTest4(value="java",aaa=99,bbb={"study"})
class Demo{
    @MyTest4(value="无为而治",aaa=9.9,bbb={"心静","悟道"})
    public void test1()
    {

    }
}