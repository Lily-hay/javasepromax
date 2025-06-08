package com.lily.d1_char_stream;

import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

public class FileWriterDemo {
    public static void main(String[] args) throws IOException {
        try (Writer fw = new FileWriter("day10-io\\src\\com\\lily\\d1_char_stream\\lily2.txt",true)) {
            //1、写一个字符出去
            fw.write('a');
            fw.write(98);
            fw.write("\r\n");
            //2、写一个字符串出去
            fw.write("我爱Java666");
            fw.write("\r\n");

            //3、写一个字符串的一部分出去
            fw.write("woai中国",4,2);
            fw.write("\r\n");
            //4、写一个字符数组出去
            char[] str="java".toCharArray();
            fw.write(str);
            fw.write("\r\n");
            //fw.flush();刷新缓冲区，刷新后，流可以继续使用
            //fw.close();关闭后流不可以使用

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
