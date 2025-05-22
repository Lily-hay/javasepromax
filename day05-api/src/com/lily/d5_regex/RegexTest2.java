package com.lily.d5_regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexTest2 {
    public static void main(String[] args) {
        //正则化爬取内容
        String data="来黑马程序员学习Java.\n"+
                "电话：16576970082. 18048580850\n"+
                "或联系邮箱：baidu@itcast.cn\n"+
                "座机电话：01036287492. 010-361864969"+
                "邮箱：bodai@itvast.cn. \n"+
                "邮箱2：blei006@163.com. \n"+
                "热线电话：400-618-9090 ， 400-618-4000 \n"+
                "4006184000. 4006189090";
        Pattern pattern= Pattern.compile("(\\w{2,30}@\\w{2,20}(\\.\\w{2,20}){1,2})|(1[3-9]\\d{9})" +
                "|(0\\d{2,6}-?[1-9]\\d{3,10})|(400-?[1-9]\\d{2,6}-?[1-9]\\d{2,6})");
        Matcher matcher=pattern.matcher(data);
        while(matcher.find()){
            String info= matcher.group();
            System.out.println(info);
        }
    }
}
