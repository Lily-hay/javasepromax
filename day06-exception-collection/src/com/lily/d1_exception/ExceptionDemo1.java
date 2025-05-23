package com.lily.d1_exception;

public class ExceptionDemo1 {
    public static void main(String[] args) {
        System.out.println("开始");
        try {
            System.out.println(divide(10,0));
            System.out.println("成功了");
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("结束");
    }
    public static int divide(int a,int b)
    {
        if(b==0)
        {
            System.out.println("参数有问题");
            throw new RuntimeException("/ by 0");//抛出一个异常作为返回值
        }
        int c=a/b;
        return c;
    }
}
