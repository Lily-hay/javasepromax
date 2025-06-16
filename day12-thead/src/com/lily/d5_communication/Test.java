package com.lily.d5_communication;

public class Test {
    public static void main(String[] args) {
        Dask dask=new Dask();
        new ConsummerThread("吃货1",dask).start();
        new ConsummerThread("吃货2",dask).start();
        new MakeThread("面包师1",dask).start();
        new MakeThread("面包师2",dask).start();
        new MakeThread("面包师3",dask).start();
    }
}
