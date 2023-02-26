package com.learn.socket;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.Socket;

public class SocketTCP02Client {
    public static void main(String[] args) throws IOException {

        // 1. 链接服务端
        Socket socket = new Socket(InetAddress.getLocalHost(), 9999);

        // 2. 链接上后 生成Socket对象， 通过socket.getOutputStream()
        OutputStream outputStream = socket.getOutputStream();
        // 3. 获取输出流， 写入数据 到数据通道
        outputStream.write("hello, server, this is client.".getBytes());
        // 设置结束标记
        socket.shutdownOutput();

        // 4. 获取socket 输入流 读取字节 并显示
        InputStream inputStream = socket.getInputStream();
        byte[] buf = new byte[1024];
        int readLen = 0;
        while ((readLen = inputStream.read(buf)) != -1) {
            System.out.println(new String(buf, 0, readLen));
        }

        inputStream.close();
        outputStream.close();
        socket.close();

    }
}
