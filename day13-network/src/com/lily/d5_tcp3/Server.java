package com.lily.d5_tcp3;

import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.*;

public class Server {
    public static void main(String[] args) throws Exception {
        System.out.println("===========服务器启动===========");
        ServerSocket ss=new ServerSocket(8080);
        ExecutorService pool=new ThreadPoolExecutor(3,10,10,TimeUnit.SECONDS,new ArrayBlockingQueue<>(100)
        , Executors.defaultThreadFactory(),new ThreadPoolExecutor.AbortPolicy());
        while (true) {
            Socket socket=ss.accept();
            System.out.println("一个客户端上线了："+socket.getInetAddress().getHostAddress());
            pool.execute(new ServerReader(socket));
        }

    }
}
