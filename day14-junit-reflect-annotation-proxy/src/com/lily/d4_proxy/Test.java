package com.lily.d4_proxy;

public class Test {
    public static void main(String[] args) {
        Star s=new Star("杨超越");
        //创建代理对象
        StarService proxy= ProxyUtil.createProxy(s);
        proxy.sing("红昭愿");
        System.out.println(proxy.dance());
    }
}
