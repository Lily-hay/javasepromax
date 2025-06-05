package com.lily.d1_byte_stream;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

public class FinallyDemo2 {
    public static void main(String[] args) {
        try(InputStream is = new FileInputStream("D:\\编程笔记\\kiss.png");
            OutputStream os = new FileOutputStream("D:\\编程笔记\\kiss-bak.png");) {

            byte[] buffer = new byte[1024];
            int len;
            while ((len = is.read(buffer)) != -1) {
                os.write(buffer, 0, len);
            }
        }catch(Exception e) {
                e.printStackTrace();
            }
        }
    }
