package com.lily.d6_thread_pool;

public class MyRunnable implements Runnable{

    @Override
    public void run() {
        for (int i = 1; i < 4; i++) {
            System.out.println(Thread.currentThread().getName()+"输出"+i);
            try {
                System.out.println(Thread.currentThread().getName()+"已休眠");
                Thread.sleep(Integer.MAX_VALUE);

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
