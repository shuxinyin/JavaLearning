package com.learn.properties_;

import java.io.File;
import java.io.IOException;

public class HomeworkFile {
    public static void main(String[] args) {
//        create01();
        create02();

    }

    public static void create01() {
        String filePath = "/home/xyshu/IdeaProjects/JavaLearn/src/com/learn/dataTest/homework.txt";

        File file = new File(filePath);
        if (!(file.exists())) {
            try {
                file.createNewFile();
                System.out.println("文件创建成功");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void create02() {
        String filePath = "/home/xyshu/IdeaProjects/JavaLearn/src/com/learn/dataTest/";
        File parentFile = new File(filePath);
        String fileName = "homework.txt";
        File file = new File(parentFile, fileName);

        if (!(file.exists())) {
            try {
                file.createNewFile();
                System.out.println("文件创建成功");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }


    // 根据父目录 + 子路径创建
    public static void create03() {
        String filePath = "/home/xyshu/IdeaProjects/JavaLearn/src/com/learn/dataTest/";
        String fileName = "homework.txt";
        File file = new File(filePath, fileName);
        if (!(file.exists())) {
            try {
                file.createNewFile();
                System.out.println("文件创建成功");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
