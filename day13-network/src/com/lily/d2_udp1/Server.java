package com.lily.d2_udp1;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class Server {
    public static void main(String[] args) throws Exception {
        //1、创建接收端对象
        DatagramSocket socket = new DatagramSocket(8888);
        while (true) {
            byte[] buffer=new byte[1024*64];
            //2、创建接收盒子
            DatagramPacket packet=new DatagramPacket(buffer,buffer.length);
            //3、接收数据
            socket.receive(packet);
            int len=packet.getLength();
            //获取信息
            String msg= new String(buffer,0,len);
            System.out.println(msg);
            InetAddress ip=packet.getAddress();
            System.out.println("对方IP："+ip.getHostAddress());
            System.out.println("对方端口："+packet.getPort());

        }
    }
}
