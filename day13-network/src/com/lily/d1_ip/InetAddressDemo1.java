package com.lily.d1_ip;

import java.net.InetAddress;

public class InetAddressDemo1 {
    public static void main(String[] args) throws Exception {
        InetAddress ip=InetAddress.getLocalHost();//获取本机IP地址
        System.out.println(ip.getHostAddress());
        System.out.println(ip.getHostName());

        //获取对方IP

        InetAddress ip1=InetAddress.getByName("www.baidu.com");
        System.out.println(ip1.getHostAddress());
        System.out.println(ip1.getHostName());

        //判断是否能联通
        System.out.println(ip1.isReachable(5000));
    }
}
