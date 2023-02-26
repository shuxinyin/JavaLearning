package com.learn.socket;

import java.io.IOException;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

public class SocketTCP01Client {
    public static void main(String[] args) throws IOException {

        // 1. 链接服务端
        Socket socket = new Socket(InetAddress.getLocalHost(), 9999);

        // 链接上后 生成Socket对象， 通过socket.getOutputStream()
        OutputStream outputStream = socket.getOutputStream();
        outputStream.write("hello, server".getBytes());

        outputStream.close();
        socket.close();

    }
}
