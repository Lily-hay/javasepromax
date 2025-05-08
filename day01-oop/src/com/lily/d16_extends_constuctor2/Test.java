package com.lily.d16_extends_constuctor2;

public class Test {
    public static void main(String[] args) {
        Teacher t = new Teacher("波妞",28,"Java,玩游戏");
        System.out.println(t.getName());
        System.out.println(t.getAge());
        System.out.println(t.getSkills());

    }
}
