package com.lily.d1_byte_stream;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

public class FileInputStreamDemo3 {
    public static void main(String[] args) throws Exception {
        InputStream is=new FileInputStream("day09-io\\src\\didi2.txt") ;//简洁写法
        File f=new File("day09-io\\src\\didi2.txt");
        /*long size=f.length();
        byte[] buffer=new byte[(int)size];
        System.out.println("文件的大小："+size);
        int len=is.read(buffer);
        System.out.println("读取的字节:"+len);
        System.out.println(new String(buffer));
        */
        byte[] buffer=is.readAllBytes();
        System.out.println(new String(buffer));
        is.close();
        /*缺点：不能读取大一点的文件*/

    }
}
