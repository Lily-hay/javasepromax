package com.lily.d5_tcp3;

import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintStream;
import java.net.Socket;

public class ServerReader extends Thread{
    private Socket socket;

    public ServerReader(Socket socket)
    {
        this.socket=socket;
    }

    @Override
    public void run()
    {
        try {
            OutputStream os= socket.getOutputStream();
            PrintStream pos= new PrintStream(os);
            pos.println("HTTP/1.1 200 OK");
            pos.println("Content-Type:text/html;charset=utf-8");
            pos.println();//必须换一行
            pos.println("<head>");
            pos.println("<meta charset='utf-8'>");
            pos.println("<title>");
            pos.println("黑马Java入门学习");
            pos.println("</title>");
            pos.println("</head>");
            pos.println("<body>");
            pos.println("<h1 style='color:red;font-size=20px'>听磊哥Java课程视频</h1>");
            pos.println("<h1 style='color:black;font-size=10px'>晶晶有味</h1>");
            pos.println("</body>");
            pos.close();
            socket.close();

        } catch (IOException e) {
            System.out.println("一个客户端下线了"+socket.getInetAddress().getHostAddress());
        }
    }
}
