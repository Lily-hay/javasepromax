package com.lily.d1_create;

public class ThreadDemo2 {
    public static void main(String[] args) {
        //1、创建任务类的一个对象
        Runnable target=new NewThread();
        //2、将任务类对象给子线程
        Thread t=new Thread(target);
        //3、启动子线程
        t.start();
        for (int i = 0; i < 3; i++) {
            System.out.println("主线程执行"+i);
        }
    }
}
class NewThread implements Runnable
{

    @Override
    public void run() {
        for (int i = 0; i < 3; i++) {
            System.out.println("子线程实现了"+i);
        }
    }
}