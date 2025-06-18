package com.lily.d4_tcp2;

import java.io.DataOutputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) throws Exception {
        System.out.println("==========客户端启动===========");
        //1、创建客户端对象
        Socket socket=new Socket("127.0.0.1",9999);
        //2、获取输出流，发送数据
        OutputStream os=socket.getOutputStream();
        //3、将输出流包装成特殊数据输出流
        DataOutputStream dos=new DataOutputStream(os);
        Scanner sc = new Scanner(System.in);
        while (true) {
            String msg=sc.nextLine();
            if("exit".equals(msg))
            {
                System.out.println("退出成功！");
                socket.close();
                break;
            }
            dos.writeUTF(msg);
            dos.flush();
        }

    }
}
