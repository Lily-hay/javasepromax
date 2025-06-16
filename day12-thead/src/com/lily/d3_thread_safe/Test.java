package com.lily.d3_thread_safe;

public class Test {
    public static void main(String[] args) {
        Account acc=new Account("adin168",100000);
        new DrawThread("小红",acc).start();
        new DrawThread("小明",acc).start();
    }

}
