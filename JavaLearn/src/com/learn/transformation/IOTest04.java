package com.learn.transformation;


import java.io.*;

/**
 * @author shuxy
 * @date 2023/3/4
 * @description code demo for BufferedReader、BufferedWriter
 */
public class IOTest04 {

    public static void main(String[] args) throws IOException {
        String srcPath = "/home/xyshu/Desktop/WorkNodes";
        String dstPath = "/home/xyshu/Desktop/WorkNodesCopy";

        BufferedReaderTransform bufferedReaderTransform = new BufferedReaderTransform();
        bufferedReaderTransform.copyFileString(srcPath, dstPath);
    }
}

class BufferedReaderTransform {

    public void copyFileString(String srcPath, String dstPath) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(srcPath));
        BufferedWriter bw = new BufferedWriter(new FileWriter(dstPath));
        int len = 0;
        while ((len = br.read()) != -1) {
            bw.write(len);
        }

        // readLine 方法
//        String line = "";
//        while ((line = br.readLine()) != null) {
//            bw.write(line);
//            bw.write('\n');
//        }
        //释放资源
        bw.close();
        br.close();
    }

}
