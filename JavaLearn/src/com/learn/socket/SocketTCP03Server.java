package com.learn.socket;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

@SuppressWarnings({"all"})
public class SocketTCP03Server {
    public static void main(String[] args) throws IOException {

        // serverSocket 可以通过accept()返回多个Socket链接[多个客户端]
        ServerSocket serverSocket = new ServerSocket(9999);
        System.out.println("服务端， 在9999监听");
        Socket socket = serverSocket.accept();


        InputStream inputStream = socket.getInputStream();
        InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
        // 不加BufferedReader  是一个一个的字符读取
        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
        String s = bufferedReader.readLine();
        System.out.println(s);

        // 获取socket相关联的输出流
        OutputStream outputStream = socket.getOutputStream();
        OutputStreamWriter outputStreamWriter = new OutputStreamWriter(outputStream);
        BufferedWriter bufferedWriter = new BufferedWriter(outputStreamWriter);

        // 3. 获取输出流， 写入数据 到数据通道
        bufferedWriter.write("hello, client, this is server.");
        bufferedWriter.newLine();        // 设置结束标记
        bufferedWriter.flush();

        bufferedWriter.close();
        inputStream.close();
        socket.close();
        serverSocket.close();

    }
}
