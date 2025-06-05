package com.lily.d1_byte_stream;

import java.io.FileOutputStream;
import java.io.OutputStream;

public class FileOutputStreamDemo1 {
    public static void main(String[] args) throws Exception {
        OutputStream os = new FileOutputStream("day09-io\\src\\didi3.txt");
        os.write('a');
        os.write(97);
        os.write("\r\n".getBytes());
        byte[] bytes="abc我爱你中国666".getBytes();
        os.write(bytes);
        os.write("\r\n".getBytes());
        os.write(bytes,3,15);
        //io流管道属于系统资源，会占用内存和相应的内存资源
        //用完之后要关闭管道，释放被占用的内存资源
        //os.flush();//刷新缓存在内存中的数据到磁盘中
        os.close();//关闭包含刷新！

    }
}
