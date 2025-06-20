package com.lily.d2_reflect;

public class Cat {
    public static int s;
    public static final String COUNTY="中国";
    private String name;
    private int age;

    public Cat()
    {
        System.out.println("无参构造器执行了");
    }

    private Cat(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public static int getS() {
        return s;
    }

    public static void setS(int s) {
        Cat.s = s;
    }

    public String getName() {
        return name;
    }
    private void run()
    {
        System.out.println("跑得快");
    }
    public void eat()
    {
        System.out.println("吃得多");
    }
    private String eat(String name)
    {
        return "猫猫吃得多"+name;
    }

    @Override
    public String toString() {
        return "Cat{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
