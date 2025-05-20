package com.lily.so;

import java.util.Arrays;

public class Demo1_1 {
    public static void main(String[] args) {
        //选择排序算法
        int[] arr={5,2,3,1};
        /*每一轮找一个最小值
         * */
        for (int i = 0; i < arr.length-1; i++) {
            //定义一个每轮数的最小值位置,避免多次交换
            int min=i;
            //轮数
            /*      j
             * 0     123
             * 1     23
             * 2     3
             * */
            for(int j=i+1;j<arr.length;j++) {
                if(arr[min]>arr[j]) {
                    min=j;
                }
            }
            if(min!=i)
            {
                int temp=arr[min];
                arr[min]=arr[i];
                arr[i]=temp;
            }
        }
        System.out.println(Arrays.toString(arr));
    }
}
