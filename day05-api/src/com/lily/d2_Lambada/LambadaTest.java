package com.lily.d2_Lambada;

public class LambadaTest {
    public static void main(String[] args) {
        Swimming s1=new Swimming() {
            @Override
            public void swim() {
                System.out.println("学生跑得快~~~~~~~");
            }
        };
        s1.swim();
        Swimming s2=()->{
            System.out.println("老师跑得快------");
        };
        s2.swim();
    }
}

interface Swimming{
    void swim();
}
abstract class Animal{

}