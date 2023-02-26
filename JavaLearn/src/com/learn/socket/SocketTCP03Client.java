package com.learn.socket;

import java.io.*;
import java.net.InetAddress;
import java.net.Socket;

public class SocketTCP03Client {
    public static void main(String[] args) throws IOException {

        // 1. 链接服务端
        Socket socket = new Socket(InetAddress.getLocalHost(), 9999);

        // 2. 链接上后 生成Socket对象， 通过socket.getOutputStream()
        OutputStream outputStream = socket.getOutputStream();
        OutputStreamWriter outputStreamWriter = new OutputStreamWriter(outputStream);
        BufferedWriter bufferedWriter = new BufferedWriter(outputStreamWriter);

        // 3. 获取输出流， 写入数据 到数据通道
        bufferedWriter.write("hello, server, this is client.");
        bufferedWriter.newLine();        // 设置结束标记
        bufferedWriter.flush();


        // 4. 获取socket 输入流 读取字节 并显示
        InputStream inputStream = socket.getInputStream();
        InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
        // 不加BufferedReader  是一个一个的字符读取
        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
        String s = bufferedReader.readLine();
        System.out.println(s);

        inputStream.close();
        outputStream.close();
        socket.close();

    }
}
