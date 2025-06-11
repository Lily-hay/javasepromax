package com.lily.d8_demo;

public class BeerDemo {
    public static int totalNumber;
    public static int lastBottleNumber;
    public static int lastCoverNumber;
    public static void main(String[] args) {
        //啤酒两块一瓶，4个盖子可换一瓶，两个空瓶可换一瓶，10元购买，能买多少瓶，最后剩余多少个盖子和空瓶

        buy(10);
        System.out.println(totalNumber);
        System.out.println(lastBottleNumber);
        System.out.println(lastCoverNumber);
    }
    public static void buy(int money){
        int number=money/2;
        totalNumber+=number;
        int totalBottleNUmber=lastBottleNumber+number;
        int totalCoverNUmber=lastCoverNumber+number;
        int allMoney=0;
        if(totalBottleNUmber>=2){
            allMoney+=(totalBottleNUmber/2)*2;
        }
        lastBottleNumber=totalBottleNUmber%2;
        if(totalCoverNUmber>=4)
        {
            allMoney+=(totalCoverNUmber/4)*2;
        }
        lastCoverNumber=totalCoverNUmber%4;
        if(allMoney>=2)
        {
            buy(allMoney);
        }

    }
}
