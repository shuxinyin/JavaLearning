package com.learn.socket;

import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class SocketTCP01Server {
    public static void main(String[] args) throws IOException {

        // serverSocket 可以通过accept()返回多个Socket链接[多个客户端]
        ServerSocket serverSocket = new ServerSocket(9999);
        System.out.println("服务端， 在9999监听");
        Socket socket = serverSocket.accept();


        InputStream inputStream = socket.getInputStream();
        byte[] buf = new byte[1024];
        int readLen = 0;
        while ((readLen = inputStream.read(buf)) != -1) {
            System.out.println(new String(buf, 0, readLen));
        }

        inputStream.close();
        socket.close();
        serverSocket.close();
    }
}
