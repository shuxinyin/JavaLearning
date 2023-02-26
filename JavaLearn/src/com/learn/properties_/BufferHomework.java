package com.learn.properties_;
/**
 * 若源文件是gbk 编码， 出现中文乱码
 * 采用转换流 FileInputStream -> InputStreamReader(可以指定编码) --> BufferedReader
 */


import java.io.*;

public class BufferHomework {
    public static void main(String[] args) throws IOException {
        String filePath = "/home/xyshu/IdeaProjects/JavaLearn/src/com/learn/dataTest/t3.txt";
        BufferedReader br = new BufferedReader(new FileReader(filePath));

        String dstFilePath = "/home/xyshu/IdeaProjects/JavaLearn/src/com/learn/dataTest/t4.txt";
        BufferedWriter bw = new BufferedWriter(new FileWriter(dstFilePath));

        String s = new String();
        int dataLength = 0;
        int index =1;
        while ((dataLength = br.read()) != -1){
            s = "第" + (index++) + "行: " + br.readLine();
            System.out.println(s);
            bw.write(s);
            bw.write("\n");
        }

        br.close();
        bw.close();
    }
}
