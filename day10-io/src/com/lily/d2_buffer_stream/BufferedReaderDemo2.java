package com.lily.d2_buffer_stream;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.Reader;

public class BufferedReaderDemo2 {
    public static void main(String[] args) {
        try (
                Reader fr= new FileReader("day10-io/src/com/lily/d1_char_stream/llily1.txt");

                //把低级的字符输入流包装成高级的字符缓冲输入流
                BufferedReader br=new BufferedReader(fr);
        ){
            /*char[] chs=new char[3];
            int len;
            while((len=br.read(chs))!=-1)
            {
                String str=new String(chs,0,len);
                System.out.print(str);
            }*/
            //缓冲字符流多一个功能，逐行读取
            String line;
            while((line=br.readLine())!=null)
            {
                System.out.println(line);
            }
        } catch (Exception e) {

            e.printStackTrace();
        }
    }
}
