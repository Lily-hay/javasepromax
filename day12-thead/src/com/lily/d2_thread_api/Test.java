package com.lily.d2_thread_api;

public class Test {
    public static void main(String[] args) throws InterruptedException {
        Thread t=new MyThread("线程1");
        //设置线程名字
        //t.setName("线程1");
        t.start();

        /*Thread t1=new MyThread("线程2");
            //t.setName("线程2");
        t1.start();*/
        //输出当前线程
        Thread m=Thread.currentThread();
        System.out.println(m);
        m.setName("main");
        for (int i = 0; i < 4; i++) {
            if(i==2)
            {
                t.join();//让t先执行完
            }
            System.out.println(m.getName()+"输出："+i);
            //t.sleep(1000);//沉睡
        }

    }
}
class MyThread extends Thread {
    public MyThread (String name)
    {
        super(name);
    }
    @Override
    public void run() {
        for (int i = 0; i < 4; i++) {
            System.out.println(currentThread().getName()+"输出了" + i);
        }
    }
}