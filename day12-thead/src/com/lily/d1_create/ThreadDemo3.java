package com.lily.d1_create;

public class ThreadDemo3 {
    public static void main(String[] args) {
        //创建Runnable匿名内部类对象
        Runnable target=new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 3; i++) {
                    System.out.println("子线程1执行"+i);
                }
            }
        };
        Thread t=new Thread(target);
        t.start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 2; i++) {
                    System.out.println("子线程2执行"+i);
                }
            }
        }).start();

        new Thread(() ->
            {
                for (int i = 0; i < 2; i++) {
                    System.out.println("子线程3执行"+i);
                }
            }
        ).start();

    }
}
