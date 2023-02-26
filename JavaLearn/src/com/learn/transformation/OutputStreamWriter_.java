package com.learn.transformation;

import java.io.*;

public class OutputStreamWriter_ {
    public static void main(String[] args) throws IOException {
        String filePath = "/home/xyshu/IdeaProjects/JavaLearn/src/com/learn/dataTest/t1.txt";
        String charSet = "utf-8";

        // FileOutputStream字节流 --> OutputStreamWriter 字符流
        OutputStreamWriter osw = new OutputStreamWriter(new FileOutputStream(filePath), charSet);
        osw.write("hello, 新世界WC!");
        osw.close();
        System.out.println(charSet + "格式， 保存成功！");
    }
}
