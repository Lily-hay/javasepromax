package com.lily.d2_buffer_stream;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.Writer;

public class BufferedWriterDemo3 {
    public static void main(String[] args) {
        try (
                Writer fw = new FileWriter("day10-io\\src\\com\\lily\\d1_char_stream\\lily2.txt",true);
                BufferedWriter bw=new BufferedWriter(fw);
        ) {
            //1、写一个字符出去
            bw.write('a');
            bw.write(98);
            //自带的换行功能
            bw.newLine();
            //2、写一个字符串出去
            bw.write("我爱Java666");
            bw.newLine();

            //3、写一个字符串的一部分出去
            bw.write("woai中国",4,2);
            bw.newLine();
            //4、写一个字符数组出去
            char[] str="java".toCharArray();
            bw.write(str);
            bw.newLine();
            //fw.flush();刷新缓冲区，刷新后，流可以继续使用
            //fw.close();关闭后流不可以使用

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
