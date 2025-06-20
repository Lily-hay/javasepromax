package com.lily.d2_reflect;



import org.junit.Test;

import java.lang.reflect.Constructor;

public class Test2Constructor {
     @Test
    public void testGetConstructors()
    {
        Class c=Cat.class;
        //获取类的全部构造器对象
        Constructor[] constructors=c.getDeclaredConstructors();
        for (Constructor constructor : constructors) {
            System.out.println(constructor.getName()+">>>"+constructor.getParameterCount());
        }
    }
    @Test
    public void testGetConstructor() throws Exception {
        Class c= Cat.class;
        //Constructor con1=c.getConstructor();不能拿私有的
        Constructor con1=c.getDeclaredConstructor();//定位无参数
        Constructor con2=c.getDeclaredConstructor(String.class,int.class);//定位有参数

        //3、得到构造器的目的依然是初始化对象返回
        Cat c1 =(Cat) con1.newInstance();
        System.out.println(c1);

        con2.setAccessible(true);//禁止访问权限（暴力反射）
        Cat c2=(Cat)con2.newInstance("叮当猫",30);
        System.out.println(c2);
    }

}
