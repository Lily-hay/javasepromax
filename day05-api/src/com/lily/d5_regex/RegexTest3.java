package com.lily.d5_regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexTest3 {
    public static void main(String[] args) {
        String data="欢迎张全蛋光临本系统！他删库并跑路了！欢迎李二狗光临本系统！"+
                "欢迎马六甲光临本系统！他浏览量好多照片！欢迎夏洛克光临本系统！他在六点送出了嘉年华！";
        Pattern pattern=Pattern.compile("欢迎(.*?)光临");
        Matcher matcher=pattern.matcher(data);
        while(matcher.find())
        {
            String sr=matcher.group(1);
            System.out.println(sr);
        }

    }
}
