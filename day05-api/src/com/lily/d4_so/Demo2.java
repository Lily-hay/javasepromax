package com.lily.d4_so;

public class Demo2 {
    public static void main(String[] args) {
        //二分查找
        int[] arr={7,23,79,81,103,127,131,147};
        System.out.println("79的索引是："+searchDataIndex(arr,79));
        System.out.println("179的索引是："+searchDataIndex(arr,179));

    }
    public static int searchDataIndex(int[] arr, int target) {
        int low = 0;
        int high = arr.length-1;
        while (low <= high) {
            int mid = (low + high)/2;
            if(target>arr[mid]) {
                low = mid+1;
            }
            else if(target<arr[mid]) {
                high = mid-1;
            }
            else {
                return mid;
            }
        }
        return -1;
    }
}
