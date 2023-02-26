package com.learn.properties_;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class Properties01 {
    public static void main(String[] args) throws IOException {
        String filePath = "/home/xyshu/IdeaProjects/JavaLearn/src/com/learn/dataTest/mysql.properties";

        Properties properties = new Properties();
        properties.load(new FileReader(filePath));

        properties.list(System.out);

        String user = properties.getProperty("user");
        String pwd = properties.getProperty("pwd");


    }
}
