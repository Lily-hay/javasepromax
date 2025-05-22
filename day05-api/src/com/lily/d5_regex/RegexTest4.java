package com.lily.d5_regex;

public class RegexTest4 {
    public static void main(String[] args) {
        String data="古力娜扎sxai289迪丽热巴gedu马儿扎哈ddhu789卡尔巴哈";
        //1、将中间非中文替换为-
        String result=data.replaceAll("\\w+","-");
        System.out.println(result);

        //2、将人名提取出来
        String[] names=data.split("\\w+");
        for(int i=0;i<names.length;i++){
            System.out.println(names[i]);
        }

    }
}
