package com.lily.d1_char_stream;

import java.io.FileReader;
import java.io.Reader;

public class FileReaderDemo1 {
    public static void main(String[] args) throws Exception {
        //1、创建文件字符输入通道与源文件接通
        Reader fr= new FileReader("day10-io\\src\\com\\lily\\d1_char_stream\\llily.txt");
        //2、读取一个字符回来，没有返回-1
        /*int c1=fr.read();
        System.out.println((char)c1);
        int c2=fr.read();
        System.out.println((char)c2);
        int c3= fr.read();
        System.out.println(c3);*/

        //3、使用循环解决
        int c;
        while((c= fr.read())!=-1)
        {
            System.out.println((char)c);
        }
        /*
        * 解决了乱码的问题
        * 性能较差*/


    }
}
