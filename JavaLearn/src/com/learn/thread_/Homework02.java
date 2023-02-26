package com.learn.thread_;

public class Homework02 {
    public static void main(String[] args) {
        A a = new A();
        Thread thread1 = new Thread(a);
        thread1.setName("user1");
        Thread thread2 = new Thread(a);
        thread2.setName("user2");
        thread1.start();
        thread2.start();


    }
}


class A implements Runnable {
    private int totalMoney = 10000;

    public void getMoney() {
        while (true) {
            synchronized(this) {
                if (totalMoney < 1000) {
                    break;
                }
                totalMoney -= 1000;
                System.out.println(Thread.currentThread().getName() + "取1000， 余额: " + totalMoney);
            }
            try {
                Thread.sleep(1000);

            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }

    @Override
    public void run() {
        getMoney();

    }
}