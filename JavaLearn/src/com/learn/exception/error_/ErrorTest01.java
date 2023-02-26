package com.learn.exception.error_;

import java.util.Scanner;

public class ErrorTest01 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int nums = 0;
        while (true) {
            System.out.println("请输入一个数：");
            String s = scanner.next();

            try {
                int inputStr = Integer.parseInt(s);
                break;
            } catch (NumberFormatException e) {
                e.printStackTrace();

            } finally {
                System.out.println("Finished!!");
            }
        }
    }
}
