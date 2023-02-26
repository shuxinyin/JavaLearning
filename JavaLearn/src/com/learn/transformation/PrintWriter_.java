package com.learn.transformation;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class PrintWriter_ {

    public static void main(String[] args) throws IOException {
        String filePath = "/home/xyshu/IdeaProjects/JavaLearn/src/com/learn/dataTest/t2.txt";

//        PrintWriter printWriter = new PrintWriter(System.out);
        PrintWriter printWriter = new PrintWriter(new FileWriter(filePath));
        printWriter.println("hi, 新世界！！");
        printWriter.close();
    }
}
