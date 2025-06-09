package com.lily.d4_print_stream;

import java.io.FileOutputStream;
import java.io.PrintStream;

public class PrintStreamDemo2 {
    public static void main(String[] args) throws Exception {
        //输入语句的重定向
        System.out.println("红豆生南国");
        PrintStream ps=new PrintStream(new FileOutputStream("day10-io/src/com/lily/aka1.txt"));
        System.setOut(ps);
        //后面输出的语句都在文件里了
        System.out.println("春来生几支");

    }
}
