package com.lily.d1_byte_stream;

import java.io.FileInputStream;
import java.io.InputStream;

public class FileInputStreamDemo2 {
    public static void main(String[] args) throws Exception {
        InputStream is=new FileInputStream("day09-io\\src\\didi1.txt");
        byte[] buffer=new byte[3];//一次读取三个
        /*int len=is.read(buffer);
        System.out.println("内容："+new String(buffer));//下次读取还用同一个桶
        System.out.println("长度："+len);
        //要读取多少倒多少
        int len2=is.read(buffer);
        System.out.println("内容："+new String(buffer,0,len2));
        System.out.println(len2);*/

        //循环改进
        int len;
        while( (len=is.read(buffer))!=-1)
        {
            System.out.println(new String(buffer,0,len));
        }
        /*拓展：
        * 1、性能比较好
        * 2、仍然没有解决汉字乱码的问题*/
    }
}
