package com.lily.d2_udp1;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) throws Exception {
        //1、创建发送端对象（抛韭菜的人）
        DatagramSocket socket=new DatagramSocket();

        //2、创建一个数据包对象，负责封装发送的数据（盘子）
        /*
        * 参数一：发送数据，字节数组
        * 参数二：发送数据大小
        * 参数三：目标IP地址
        * 参数四：接收端端口号
        * */
        Scanner sc=new Scanner(System.in);
        while (true) {
            System.out.println("请说：");
            String msg=sc.nextLine();
            if("exit".equals(msg))
            {
                socket.close();
                break;
            }
            byte[] buffer=msg.getBytes();
            DatagramPacket packet=new DatagramPacket(buffer,buffer.length, InetAddress.getLocalHost(),8888);
            //3、发送数据
            socket.send(packet);
            System.out.println("发送完毕！");
        }
        //4、关闭资源


    }
}
