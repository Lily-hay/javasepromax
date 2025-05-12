package com.lily.d12_interface_jdk8;

public interface A {
    //1、默认方法,用default修饰
    //默认用public修饰
    //必须用接口实现类调用
    default void run()
    {
        go();
        System.out.println("跑得很快");
    }

    //2、私有方法（jdk9开始才有）
    //只能由当前接口里的默认方法或私有方法调用
    private void go()
    {
        System.out.println("开始跑");
    }

    //3、静态方法
    //默认用public修饰
    //接口的静态方法由接口本身调用
    static void inAddr()
    {
        System.out.println("我爱学Java");
    }
}
