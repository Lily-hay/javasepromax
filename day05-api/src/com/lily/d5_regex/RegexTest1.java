package com.lily.d5_regex;

import java.util.Scanner;

public class RegexTest1 {
    public static void main(String[] args) {
        //checkMail();
        checkPhone();
    }

    private static void checkPhone() {
        System.out.println("请输入手机号：");
        Scanner sc = new Scanner(System.in);
        String email=sc.nextLine();
        if(email.matches("1[3-9]\\d{9}"))
        {
            System.out.println("手机号合法，录入成功");
        }
        else
        {
            System.out.println("手机号有误");
        }

    }

    public static void checkMail() {
        System.out.println("请输入邮箱：");
        Scanner sc = new Scanner(System.in);
        String email=sc.nextLine();
        if(email.matches("\\w{2,30}@\\w{2,20}(\\.\\w{2,20}){1,2}"))
        {
            System.out.println("邮箱合法，录入成功");
        }
        else
        {
            System.out.println("邮箱有误");
        }
    }
}
