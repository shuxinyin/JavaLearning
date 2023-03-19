package com.learn.transformation;

import java.io.*;

/**
 * @author shuxy
 * @date 2023/3/4
 * @description: code demo for BufferedInputStream and BufferedOutputStream
 */
public class IOTest02 {

    public static void main(String[] args) {
        String srcPath = "/home/xyshu/Desktop/WorkNodes";
        String dstPath = "/home/xyshu/Desktop/WorkNodesCopy";

        BufferedStreamTransform BufferedStreamTransform = new BufferedStreamTransform();
        BufferedStreamTransform.copyFile(srcPath, dstPath);
    }
}

class BufferedStreamTransform {
    public void copyFile(String srcPath, String dstPath) {
        byte[] buffer = new byte[1000];
        try {
            FileInputStream fis = new FileInputStream(srcPath);
            BufferedInputStream bis = new BufferedInputStream(fis);

            FileOutputStream fos = new FileOutputStream(dstPath);
            BufferedOutputStream bos = new BufferedOutputStream(fos);

            int numBytes;
            while ((numBytes = bis.read(buffer)) != -1) {
                bos.write(buffer, 0, numBytes);
            }
            //bos.flush();

            System.out.println(srcPath + " is successfully copied to " + dstPath);

            bis.close();
            bos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}