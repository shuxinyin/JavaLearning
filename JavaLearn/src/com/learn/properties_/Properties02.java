package com.learn.properties_;

import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class Properties02 {
    public static void main(String[] args) throws IOException {
        String filePath = "/home/xyshu/IdeaProjects/JavaLearn/src/com/learn/dataTest/mysql.properties";

        Properties properties = new Properties();

        properties.setProperty("charset", "utf-8");
        properties.setProperty("user", "小明");  // 注意 中文保存的是unicode码值
        properties.setProperty("pwd", "abc123");

        properties.store(new FileOutputStream(filePath), "mysql properties");
        System.out.println("save properties finished!!");
    }
}
