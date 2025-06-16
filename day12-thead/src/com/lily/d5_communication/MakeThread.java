package com.lily.d5_communication;

public class MakeThread extends Thread{
    private Dask dask;
    public MakeThread(String name, Dask dask)
    {
        super(name);
        this.dask=dask;
    }
    @Override
    public void run()
    {

        while (true) {
            try {
                Thread.sleep(1000);
                dask.put();
            } catch (Exception e) {
                e.printStackTrace();
            }

        }
    }

}
