package com.lily.d15_extends_constuctor;

public class Wolf extends Animal {
    public Wolf(){
        //super();//写不写都有，调用父类的无参构造器
        System.out.println("子类的无参构造器执行了");
    }
    public Wolf(String n)
    {
        //super(n);//写不写都有，调用父类的有参构造器
        System.out.println("子类的无参构造器执行了");
    }
}
