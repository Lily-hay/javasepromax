package com.lily.so;

public class Demo1 {
    public static void main(String[] args) {
        //选择排序算法
        int[] arr={5,2,3,1};
        /*每一轮找一个最小值
        * */
        for (int i = 0; i < arr.length-1; i++) {
            //轮数
            /*      j
            * 0     123
            * 1     23
            * 2     3
            * */
            for(int j=i+1;j<arr.length;j++) {
                if(arr[i]>arr[j]) {
                    int temp=arr[i];
                    arr[i]=arr[j];
                    arr[j]=temp;
                }
            }
        }
    }
}
