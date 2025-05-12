package com.lily.innerclass4;

public class Test2 {
    public static void main(String[] args) {
        //匿名内部类的使用场景
        //方法1
        Swimming s=new Swimming() {
            @Override
            public void swim() {
                System.out.println("老师游得慢-----");
            }
        };
        go(s);
        //方法二
        go(new Swimming() {
            @Override
            public void swim() {
                System.out.println("学生游得快·········");
            }
        });

    }

    public static void go(Swimming s)
    {
        System.out.println("开始-------");
        s.swim();
        System.out.println("结束------");
    }
}
interface Swimming
{
    public void swim();
}