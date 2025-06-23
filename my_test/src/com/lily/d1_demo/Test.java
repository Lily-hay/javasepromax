package com.lily.d1_demo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

/*双色球中奖*/
public class Test {
    public static void main(String[] args) {
        Random r=new Random();
        ArrayList<Integer> redArr=new ArrayList<>();
        while(true)
        {
            int re=r.nextInt(34)+1;
            if(!redArr.contains(re))
            {
                redArr.add(re);
            }
            if(redArr.size()==6)
            {
                break;
            }
        }
        System.out.println(redArr);
        Collections.sort(redArr);
        System.out.println(redArr);
        int blue=r.nextInt(14)+1;
        redArr.add(blue);
        System.out.println(redArr);
        int[] arr={10,12,30,16,7,17,12};
        int count=0;
        int i=0;
        for (Integer red : redArr) {
            if(red==arr[i])
            {
                count++;
            }
            i++;
        }
        System.out.println("中了"+count+"个红球");
        if(blue==arr[arr.length-1])
        {
            System.out.println("中了一个蓝球");
        }
        else
        {
            System.out.println("中了0个蓝球");
        }
    }

}
