package com.learn.transformation;

import java.io.*;

/**
 * FileInputStream(filePath) 字节流 --> InputStreamWriter(, charSet) 字符流
 */
public class InputStreamReader_ {
    public static void main(String[] args) throws IOException {
        String filePath = "/home/xyshu/IdeaProjects/JavaLearn/src/com/learn/dataTest/t1.txt";
        String charSet = "utf-8";

        // FileOutputStream字节流 --> OutputStreamWriter 字符流
        InputStreamReader isr = new InputStreamReader(new FileInputStream(filePath), charSet);

        // 一个字节一个读取
//        int readData = 0;
//        while ((readData = isr.read()) != -1) {
//            System.out.print((char) readData);
//        }

        BufferedReader bufferedReader = new BufferedReader(isr);
        String s = bufferedReader.readLine();
        System.out.println("bufferedReader:" + s);

        isr.close();

    }
}
