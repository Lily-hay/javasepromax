package com.lily.d2_demo;

import java.util.ArrayList;
import java.util.Random;

public class Test {
    public static void main(String[] args) {
        ArrayList<Person> arr=new ArrayList<>();
        Random r=new Random();
        for (int i = 1; i <= 100; i++) {

            int perId=r.nextInt(199)+1;

            if(isRepeat(arr,perId))
            {
                i--;
                continue;
            }
            Person p=new Person(perId,i);
            arr.add(p);
        }
        while(true)
        {
            ArrayList<Person>lastArr=new ArrayList<>();
            for (int i = 1; i < arr.size(); i+=2) {
                lastArr.add(arr.get(i));
            }
            if(lastArr.size()==1)
            {
                int num=lastArr.get(0).getId();
                int firstLoc=lastArr.get(0).getFirstLoc();
                System.out.println("幸存者编号为："+num);
                System.out.println("位置："+firstLoc);
                break;
            }
            arr=lastArr;
        }

    }
    public static boolean isRepeat(ArrayList<Person> arr,int id)
    {
        for (Person person : arr) {
            if(person.getId()==id)
            {
                return true;
            }
        }
        return false;
    }

}
