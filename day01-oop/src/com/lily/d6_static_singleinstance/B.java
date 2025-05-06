package com.lily.d6_static_singleinstance;
/*饿汉式单例，需要用时，才创建对象，延迟加载对象*/
public class B {
    private static B b;
    private B(){

    }
    public static B getInstance(){
        //判断是否时第一次创建对象
        if(b==null){
            b=new B();
        }
        return b;
    }
}
