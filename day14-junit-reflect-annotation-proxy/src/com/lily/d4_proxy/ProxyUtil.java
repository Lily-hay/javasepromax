package com.lily.d4_proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class ProxyUtil {
    public static <T> T createProxy(T s)
    {
        //参数一：用于执行哪个类加载器去加载生成的代理类
        //参数二;用于指定代理类需要的接口，明星类实现类哪些接口，代理类就实现哪些接口
        //参数三：用来指定代理类如何去代理
        T proxy =(T) Proxy.newProxyInstance(ProxyUtil.class.getClassLoader(), s.getClass().getInterfaces(), new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                //用来声明代理对象要干的事
                //参数一：proxy接收到代理对象本身
                //参数二：method代表正在被代理的方法
                //参数三：args代表正在被代理的方法的参数
                String methodName = method.getName();
                if ("sing".equals(methodName)) {
                    System.out.println("准备话筒，收费20万！");
                } else if ("dance".equals(methodName)) {
                    System.out.println("准备场地，收款100万！");
                }
                Object result = method.invoke(s, args);


                return result;
            }
        });
        return proxy;
    }
}
