package com.lily.d2_polymorphism;

public class Test {
    public static void main(String[] args) {
        Animal a=new Cat();//右边的对象是解耦合的，更便于扩展和维护
        a.cry();
        Cat c=new Cat();
        Dog d=new Dog();
        go(c);
        go(d);

    }
    public static void go(Animal a)//定义方法时，使用父类类型的形参，可以接受一切子类对象，扩展性更强，更便利
    {
        System.out.println("----开始------");
        a.cry();
        //a.catchFish//多态下的问题：不能直接调用子类独有的行为
        System.out.println("-------结束--------");
    }
}
