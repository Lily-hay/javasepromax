package com.lily.d4_print_stream;

import java.io.PrintWriter;

public class PrintStreamDemo {
    public static void main(String[] args) {
        try(
                //PrintStream ps=new PrintStream("day10-io/src/com/lily/d4_print_stream/aka.txt");
                PrintWriter ps=new PrintWriter("day10-io/src/com/lily/aka.txt");
                ) {
            ps.print('a');
            ps.print(97);
            ps.print(true);
            ps.print("你好");
            ps.println("okk");
            ps.println("fine");

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
