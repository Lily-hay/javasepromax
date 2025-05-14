package com.lily.d2_stringjoiner;

import java.util.StringJoiner;

public class Test {
    public static void main(String[] args) {
        int[] arr={11,12,13};
        System.out.println(getArrayData(arr));

    }
    public static String getArrayData(int[] arr)
    {

        StringJoiner s1 = new StringJoiner(",","[","]");//参数分别为中间的拼接符、开始、结束
        for (int i = 0; i < arr.length; i++) {

            s1.add(Integer.toString(arr[i]));
        }
        return s1.toString();
    }
}
