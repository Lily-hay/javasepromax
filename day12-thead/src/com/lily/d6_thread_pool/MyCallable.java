package com.lily.d6_thread_pool;

import java.util.concurrent.Callable;

public class MyCallable implements Callable<String> {
    private int n;
    public MyCallable(int n)
    {
        this.n=n;
    }
    int sum=0;
    @Override
    public String call() throws Exception {
        for (int i = 0; i < n; i++) {
            sum+=i;
        }
        return Thread.currentThread().getName()+"输出的结果是："+sum;
    }
}
