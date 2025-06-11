package com.lily.d8_demo;

public class RabbitDemo {
    public static void main(String[] args) {
        int number=getCount(12);
        System.out.println(number);
    }
    public static int getCount(int month)
    {
        if(month==1 ||month==2){
            return 1;
        }
        return getCount(month-1)+getCount(month-2);
        // 1 2 3 4 5 6
        // 1 1 2 3 5 8

    }
}
