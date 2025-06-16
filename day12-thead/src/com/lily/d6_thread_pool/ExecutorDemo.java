package com.lily.d6_thread_pool;

import java.util.concurrent.*;

public class ExecutorDemo {
    public static void main(String[] args) {
        ExecutorService pool= Executors.newFixedThreadPool(3);
        Future<String> f1 = pool.submit(new MyCallable(100));
        Future<String> f2 = pool.submit(new MyCallable(200));
        Future<String> f3 = pool.submit(new MyCallable(300));
        try {
            String s = f1.get();
            System.out.println(s);
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            String s = f2.get();
            System.out.println(s);
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            String s = f3.get();
            System.out.println(s);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
