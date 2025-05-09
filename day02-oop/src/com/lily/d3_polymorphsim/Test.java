package com.lily.d3_polymorphsim;

public class Test {
    public static void main(String[] args) {
        Animal a=new Dog();//右边的对象是解耦合的，更便于扩展和维护
        //Dog d=(Dog) a;报错，类型不符
        go(a);

    }
    public static void go(Animal a)//定义方法时，使用父类类型的形参，可以接受一切子类对象，扩展性更强，更便利
    {
        System.out.println("----开始------");
        a.cry();
        if(a instanceof Dog)
        {
            Dog d=(Dog) a;
            d.lookdoor();
        }
        else
        {
            Cat c=(Cat) a;
            c.catchFish();
        }
        //a.catchFish//多态下的问题：不能直接调用子类独有的行为
        System.out.println("-------结束--------");
    }
}
