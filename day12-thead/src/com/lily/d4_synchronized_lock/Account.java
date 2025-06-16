package com.lily.d4_synchronized_lock;


import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

@Data
@NoArgsConstructor

public class Account {
    private String card;
    private int money;
    private Lock lk=new ReentrantLock();

    public Account(String card, int money) {
        this.card = card;
        this.money = money;
    }

    public void drawMoney(int money) {
        String name=Thread.currentThread().getName();

        try {
            lk.lock();
            if(money<=this.money)
            {
                System.out.println(name+"成功取出"+money);
                this.money-=money;
                System.out.println(name+"剩余余额为"+this.money);
            }
            else
            {
                System.out.println(name+"取钱，余额不足！");
            }
        } finally {
            lk.unlock();
        }

    }
    /*public void drawMoney(int money) {
        String name=Thread.currentThread().getName();

        synchronized (this) {
            if(money<=this.money)
            {
                System.out.println(name+"成功取出"+money);
                this.money-=money;
                System.out.println(name+"剩余余额为"+this.money);
            }
            else
            {
                System.out.println(name+"取钱，余额不足！");
            }
        }

    }*/
}
