package com.lily.d6_thread_pool;

import java.util.concurrent.*;

public class Test {
    public static void main(String[] args) {
        ExecutorService pool=new ThreadPoolExecutor(3,5,1, TimeUnit.MINUTES,
                new ArrayBlockingQueue<>(3), Executors.defaultThreadFactory(),new ThreadPoolExecutor.CallerRunsPolicy());
        Runnable target=new MyRunnable();
        pool.execute(target);//自动创建线程，并处理任务
        pool.execute(target);
        pool.execute(target);
        pool.execute(target);//复用线程
        pool.execute(target);
        pool.execute(target);
        pool.execute(target);//到了创建临时线程的时机
        pool.execute(target);//
        pool.execute(target);//超出线程最大数，拒绝新任务


    }
}
