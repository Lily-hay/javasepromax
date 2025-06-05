package com.lily.d1_byte_stream;

import java.io.*;

public class FinallyDemo1 {
    public static void main(String[] args) {
        InputStream is=null;
        OutputStream os=null;
        try {
            is = new FileInputStream("D:\\编程笔记\\kiss.png");
            os = new FileOutputStream("D:\\编程笔记\\kiss-bak.png");
            byte[] buffer = new byte[1024];
            int len;
            while ((len = is.read(buffer)) != -1) {

                os.write(buffer, 0, len);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        finally {
            try {
                os.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
            try {
                is.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
            System.out.println("复制完成");
        }


    }
}
