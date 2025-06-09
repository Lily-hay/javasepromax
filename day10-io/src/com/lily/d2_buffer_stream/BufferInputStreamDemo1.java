package com.lily.d2_buffer_stream;

import java.io.*;

public class BufferInputStreamDemo1 {
    public static void main(String[] args) {
        try(InputStream is = new FileInputStream("D:\\编程笔记\\kiss.png");
            InputStream bis=new BufferedInputStream(is);
            OutputStream os = new FileOutputStream("D:\\编程笔记\\kiss-bak.png");
            OutputStream bos=new BufferedOutputStream(os);
            ) {

            byte[] buffer = new byte[1024];
            int len;
            while ((len = bis.read(buffer)) != -1) {
                bos.write(buffer, 0, len);
            }
        }catch(Exception e) {
            e.printStackTrace();
        }
    }

}
