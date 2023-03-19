package com.learn.transformation;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * @author shuxy
 * @date 2023/3/4
 * @description code demo for FileInputStream、FileOutputStream
 */
public class IOTest01 {

    public static void main(String[] args) throws IOException {
        String srcPath = "/home/xyshu/Desktop/WorkNodes";
        String dstPath = "/home/xyshu/Desktop/WorkNodesCopy";

        FileStreamTransform fileStreamTransform = new FileStreamTransform();
        fileStreamTransform.copyFile(srcPath, dstPath);

    }
}

class FileStreamTransform {
    public void copyFile(String srcPath, String dstPath) throws IOException {
        FileInputStream sourceStream = null;
        FileOutputStream targetStream = null;

        try {
            sourceStream = new FileInputStream(srcPath);
            targetStream = new FileOutputStream(dstPath);

            // Reading source file and writing
            // content to target file byte by byte
            int temp;
            while ((temp = sourceStream.read()) != -1)
                targetStream.write((byte) temp);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            // 关闭流
            if (sourceStream != null)
                sourceStream.close();
            if (targetStream != null)
                targetStream.close();
        }

        System.out.println(srcPath + " is successfully copied to " + dstPath);

    }
}
