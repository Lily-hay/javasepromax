package com.lily.d8_demo;

import java.io.File;

public class Demo3 {
    public static void main(String[] args) {
        File fs=new File("E:\\javaprojects\\javasepromax");
        System.out.println(getSize(fs));
    }
    public static long getSize(File f)
    {
        long size=0;
        if(f.length()==0||!f.exists()||f==null){
            return size;
        }
        if(f.isFile())
        {
            size+=f.length();
            return size;
        }
        File[] files=f.listFiles();
        if(files==null || files.length==0)
        {
            return size;
        }
        for (File file : files) {
            if(file.isFile())
            {
                size+=file.length();
            }
            else
            {
                size+=getSize(file);
            }
        }
        return size;
    }
}
