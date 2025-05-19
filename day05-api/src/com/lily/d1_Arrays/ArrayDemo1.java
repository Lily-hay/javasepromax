package com.lily.d1_Arrays;

import java.util.Arrays;
import java.util.function.IntToDoubleFunction;

public class ArrayDemo1 {
    public static void main(String[] args) {
        //掌握操作数组Arrays类的常用方法
        int[] arr={11,5,22,67,2};

        //1、返回数组内容
        String result= Arrays.toString(arr);
        System.out.println(result);

        //2.得到数组内容的一个新数组，并返回新数组
        int[] arr2=Arrays.copyOfRange(arr,1,4);
        System.out.println(Arrays.toString(arr2));

        //3、扩容,长度增加
        int[] arr3=Arrays.copyOf(arr,10);
        System.out.println(Arrays.toString(arr3));

        double[] scores={100,78,90,98.5,88};
        //4、修改数组中每个数据并存入
        Arrays.setAll(scores, new IntToDoubleFunction() {
            @Override//匿名内部类
            public double applyAsDouble(int index) {
                return scores[index]+=10;
            }

        });
        System.out.println(Arrays.toString(scores));

        //5、排序
        Arrays.sort(scores);//从小到大
        System.out.println(Arrays.toString(scores));
    }

}
