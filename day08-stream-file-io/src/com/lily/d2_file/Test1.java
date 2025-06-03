package com.lily.d2_file;

import java.io.File;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

public class Test1 {
    public static void main(String[] args) {
        File f=new File("E:\\BaiduNetdiskDownload\\CUHK-SYSU(1)\\CUHK-SYSU\\images\\s2.jpg");
        //1、判断文件是否存在
        System.out.println(f.exists());

        //2、判断是否是文件
        System.out.println(f.isFile());

        //3、判断是否是文件夹
        System.out.println(f.isDirectory());

        //4、获取文件的名称
        System.out.println(f.getName());

        //5、获取文件大小，返回字节数
        System.out.println(f.length());

        //6、获取文件的最后修改时间
        long time=f.lastModified();
        DateTimeFormatter dft=DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss EEE a");
        //先将long类型转换为LocalDateTime对象
        LocalDateTime ldt=LocalDateTime.ofInstant(Instant.ofEpochMilli(time),ZoneId.systemDefault());
        String formattedTime=ldt.format(dft);
        System.out.println(formattedTime);

        //7、获取相对路径
        System.out.println(f.getPath());

        //8、获取绝对路径
        System.out.println(f.getAbsolutePath());
    }
}
