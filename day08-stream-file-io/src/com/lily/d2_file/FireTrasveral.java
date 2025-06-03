package com.lily.d2_file;

import java.io.File;

public class FireTrasveral {
    public static void main(String[] args) {
        //1、list() 获取当前目录下的所有的“一级文件名称”到一个字符串数组中去返回
        File f=new File("E:\\01-dll");
        String[] names=f.list();
        for (String name : names) {
            System.out.println(name);
        }

        //2、listFiles() 获取当前目录下所有的“一级文件对象”到一个文件对象数组中去返回
        /*注意：当主调是文件或路径不存在时，返回null
        *       当主调文件夹时空文件夹时，返回一个长度为零的数组
        *       当主调是一个有内容的文件夹时，将里面所有一级文件和文件夹的路径放在File数组中返回
        *       当主调是一个文件夹时，且里面有隐藏文件时，将里面所有文件和文件夹的路径在File数组中返回，包含隐藏文件
        *       当主调是一个文件夹时，但是没有权限访问，返回null*/
        File[] files=f.listFiles();
        for (File file : files) {
            System.out.println(file);
        }
    }
}
