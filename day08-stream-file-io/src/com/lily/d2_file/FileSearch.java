package com.lily.d2_file;

import java.io.File;

public class FileSearch {
    public static void main(String[] args) {
        File dir=new File("D:/");
        searchFile(dir,"QQ.exe");
    }

    /**
     *
     * @param dir  被搜索的文件·夹
     * @param fileName  要搜索的文件名
     */

    private static void searchFile(File dir, String fileName) {
        //1、搜索判断
        if(dir==null || !dir.exists() ||dir.isFile())
        {
            return;
        }
        //2、提取所有一级文件
        File[] files=dir.listFiles();
        if(files==null || files.length==0)
        {
            return;
        }
        //遍历
        for (File file : files) {
            if(file.isFile())
            { //是文件
                if(file.getName().contains(fileName))
                {
                    System.out.println(file.getAbsoluteFile());
                }
            }
            else {
                //文件夹
                searchFile(file,fileName);

            }
        }


    }
}
