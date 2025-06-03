package com.lily.d2_file;

import java.io.File;
import java.io.IOException;

public class Test2 {
    public static void main(String[] args) {
        //1、创建一个新文件
        File f=new File("E:\\resource\\comlily.txt");
        try {
            System.out.println(f.createNewFile());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        //2、创建新文件夹，只能创建一级文件夹
        File f2=new File("E:\\resource\\eee66");
        System.out.println(f2.mkdir());

        //3、创建文件夹，可创建多级
        File f3=new File("E:\\resource\\eee77\\ccc");
        System.out.println(f3.mkdirs());

        //4、只能删除文件和和空文件夹，不能删除非空文件夹
        System.out.println(f.delete());
        System.out.println(f2.delete());
        System.out.println(f3.delete());


    }
}
