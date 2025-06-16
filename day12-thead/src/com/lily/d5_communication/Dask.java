package com.lily.d5_communication;

import lombok.Data;

@Data
public class Dask {
    private String data;

    public synchronized void put() throws Exception {
        String name=Thread.currentThread().getName();
        if(data==null)
        {
            data=name+"做的包子";
            System.out.println(name+"做了一个包子");
            this.notifyAll();
            this.wait();
        }
        else {
            this.notifyAll();
            this.wait();
        }
    }

    public synchronized void get() throws Exception {
        String name=Thread.currentThread().getName();
        if(data==null)
        {
            this.notifyAll();
            this.wait();
        }
        else {
            System.out.println(name+"吃了一个包子");
            data=null;
            this.notifyAll();
            this.wait();
        }
    }
}
