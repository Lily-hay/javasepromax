package com.lily.d1_char_stream;

import java.io.FileReader;
import java.io.Reader;

public class FileReaderDemo2 {
    public static void main(String[] args) {
        try (
                Reader fr= new FileReader("day10-io/src/com/lily/d1_char_stream/llily1.txt");
                ){
            char[] chs=new char[3];
            int len;
            while((len=fr.read(chs))!=-1)
            {
                String str=new String(chs,0,len);
                System.out.print(str);
            }
        } catch (Exception e) {

            e.printStackTrace();
        }
    }
}
