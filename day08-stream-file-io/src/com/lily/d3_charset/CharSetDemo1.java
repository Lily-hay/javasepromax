package com.lily.d3_charset;

import java.io.UnsupportedEncodingException;
import java.util.Arrays;

public class CharSetDemo1 {
    public static void main(String[] args) throws UnsupportedEncodingException {
        String info="abc我在黑马听磊哥说nb!";
        //编码成字节
        byte[] bytes=info.getBytes();
        System.out.println(Arrays.toString(bytes));

        byte[] bytes1=info.getBytes("GBK");
        System.out.println(Arrays.toString(bytes1));

        //解码成字符
        String rs1=new String(bytes);
        System.out.println(rs1);
        String rs2=new String(bytes1,"GBK");
        System.out.println(rs2);
    }
}
