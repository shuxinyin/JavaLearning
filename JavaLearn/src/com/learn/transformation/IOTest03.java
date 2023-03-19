package com.learn.transformation;


import java.io.*;

/**
 * @author shuxy
 * @date 2023/3/4
 * @description code demo for InputStreamReader、OutputStreamWriter
 */
public class IOTest03 {

    public static void main(String[] args) throws IOException {
        String srcPath = "/home/xyshu/Desktop/WorkNodes";
        String dstPath = "/home/xyshu/Desktop/WorkNodesCopy";

        FileReaderTransform FileReaderTransform = new FileReaderTransform();
        FileReaderTransform.copyFileString(srcPath, dstPath);
    }
}

class FileReaderTransform {

    public void copyFileString(String srcPath, String dstPath) throws IOException {
        InputStreamReader isr = new InputStreamReader(new FileInputStream(srcPath), "UTF-8");
        OutputStreamWriter osw = new OutputStreamWriter(new FileOutputStream(dstPath), "UTF-8");
        //使用InputStreamReader对象中的方法read读取文件
        int len = 0;
        while ((len = isr.read()) != -1) {
            //使用OutputStreamWriter对象中的方法write,把读取的数据写入到文件中
            osw.write(len);
        }
        //释放资源
        osw.close();
        isr.close();
    }

}
