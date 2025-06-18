package com.lily.d3_tcp1;

import java.io.DataInputStream;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) throws Exception {
        System.out.println("===========服务器启动===========");
        ServerSocket ss=new ServerSocket(9999);
        Socket socket=ss.accept();
        InputStream is=socket.getInputStream();
        DataInputStream dis=new DataInputStream(is);
        while (true) {
            String msg=dis.readUTF();
            System.out.println("收到的消息为："+msg);
            System.out.println("对方IP："+socket.getInetAddress().getHostAddress());
            System.out.println("对方端口："+socket.getPort());
            System.out.println("------------------------------------");
        }
    }
}
