package com.learn.transformation;

import java.io.IOException;
import java.io.PrintStream;

public class PrintStream_ {
    public static void main(String[] args) throws IOException {
        PrintStream out = System.out;


        out.print("hello 我来了！！");
        // print底层使用write 也可以直接调用write
        out.write("hello 我来了！！".getBytes());
//        out.close();

        // 修改打印流输出位置
        String filePath = "/home/xyshu/IdeaProjects/JavaLearn/src/com/learn/dataTest/t3.txt";
        System.setOut(new PrintStream(filePath));
        System.out.println("hello 我来了~！！");


    }
}
