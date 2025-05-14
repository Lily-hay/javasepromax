package com.lily.d1_stringbuilder;

public class Test {
    public static void main(String[] args) {
        int[] arr={11,12,13};
        System.out.println(getArrayData(arr));

    }
    public static String getArrayData(int[] arr)
    {
        StringBuilder s1 = new StringBuilder();
        s1.append("[");
        for (int i = 0; i < arr.length; i++) {
            s1.append(arr[i]).append(i==arr.length-1?"":",");
        }
        s1.append("]");
        return s1.toString();
    }
}
