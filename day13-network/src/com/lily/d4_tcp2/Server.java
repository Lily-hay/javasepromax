package com.lily.d4_tcp2;

import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) throws Exception {
        System.out.println("===========服务器启动===========");
        ServerSocket ss=new ServerSocket(9999);
        while (true) {
            Socket socket=ss.accept();
            System.out.println("一个客户端上线了");
            new ServerReader(socket).start();
        }

    }
}
