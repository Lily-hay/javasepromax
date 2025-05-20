package com.lily.method_reference;

import java.util.Arrays;
import java.util.Comparator;

public class Test3 {
    public static void main(String[] args) {
        String[] names = {"mary","Jack","lily","candy","Cal"};
        /*Arrays.sort(names, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.compareToIgnoreCase(o2);
            }
        });*/
        //简化
        //Arrays.sort(names,( o1, o2)->o1.compareToIgnoreCase(o2));

        //进一步简化
        Arrays.sort(names,String::compareToIgnoreCase);
        System.out.println(Arrays.toString(names));
    }

    }

