package com.lily.d5_communication;

public class ConsummerThread extends Thread{
    private Dask dask;
    public ConsummerThread(String name, Dask dask)
    {
        super(name);
        this.dask=dask;
    }
    @Override
    public void run() {
        while (true) {
            try {
                Thread.sleep(1000);
                dask.get();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }


    }