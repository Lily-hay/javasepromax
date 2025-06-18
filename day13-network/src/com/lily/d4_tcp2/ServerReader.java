package com.lily.d4_tcp2;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
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
            InputStream is=socket.getInputStream();
            DataInputStream dis=new DataInputStream(is);
            while (true) {
                String msg=dis.readUTF();
                System.out.println("收到的消息为："+msg);
                System.out.println("对方IP："+socket.getInetAddress().getHostAddress());
                System.out.println("对方端口："+socket.getPort());
                System.out.println("------------------------------------");

            }
        } catch (IOException e) {
            System.out.println("一个客户端下线了"+socket.getInetAddress().getHostAddress());
        }
    }
}
