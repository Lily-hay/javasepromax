package com.lily.static_field;

public class Test1 {
    public static void main(String[] args) {
        new User();
        new User();
        new User();
        System.out.println(User.number);
    }
}
