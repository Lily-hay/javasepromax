package com.lily.d3_thread_safe;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Account {
    private String card;
    private int money;

    public synchronized void drawMoney(int money) {
        String name=Thread.currentThread().getName();

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
