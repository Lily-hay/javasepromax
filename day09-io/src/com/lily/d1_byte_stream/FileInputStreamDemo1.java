package com.lily.d1_byte_stream;

import java.io.FileInputStream;
import java.io.InputStream;

public class FileInputStreamDemo1 {
    public static void main(String[] args) throws Exception {
        //InputStream is=new FileInputStream(new File("day09-io\\src\\didi.txt"));//完整写法
        InputStream is=new FileInputStream("day09-io\\src\\didi.txt") ;//简洁写法

        int b;//用于记住每次读取的字节
        while((b= is.read())!=-1)
        {
            System.out.print((char)b);
        }
        is.close();
        /* 拓展：
       1、代码性能差，一次只读取一个字节
       2、会截断汉字的字节
        * */


    }
}

