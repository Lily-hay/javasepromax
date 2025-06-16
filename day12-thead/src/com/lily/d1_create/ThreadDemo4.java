package com.lily.d1_create;

import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

public class ThreadDemo4 {
    public static void main(String[] args) {
        //2、创建一个Callable对象
        Callable callable=new MyCallable(100);
        //3、将Callable 对象封装为FutureTask对象
        FutureTask<String> task=new FutureTask<>(callable);
        //FutureTask两个作用：1、是一个Runnable对象  2、可以·返回值
        Thread t=new Thread(task);
        t.start();
        try {
            String rs1 = task.get();
            System.out.println(rs1);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
//1、定义一个类实现Callable接口
class MyCallable implements Callable
{
    private int n;
    public MyCallable (int n)
    {
        this.n=n;
    }
    int sum;
    @Override
    public String call() throws Exception {
        for (int i = 0; i < n; i++) {
            sum+=i;
        }
        return n+"个数的和为:"+sum;
    }
}