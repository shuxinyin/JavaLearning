package com.learn.tankgame;

import java.awt.*;

public class Shot implements Runnable {
    public int x;
    public int y;
    public int direct;
    public int speed=5;
    public boolean isLive = true;


    public Shot(int x, int y, int direct) {
        this.x = x;
        this.y = y;
        this.direct = direct;
    }

    //    direct 表示方向(0: 向上 1 向右 2 向下 3 向左 )
    public void drawBullet(int x, int y, Graphics g) {
        g.setColor(Color.white);
        if (direct == 1) {
            g.fillOval(x, y, 10, 10); //默认黑色
        }
    }

    @Override
    public void run() {
        while (true) {
            // 休眠
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            switch (direct) {
                case 0: //表示向上
                    y -= speed;
                    break;
                case 1: //表示向右
                    x += speed;
                    break;
                case 2: //表示向下
                    y += speed;
                    break;
                case 3: //表示向左
                    x -= speed;
                    break;
                default:
                    System.out.println("暂时没有处理");
            }
            // 子弹超出面板， 应该销毁
            System.out.println("子弹 x=" + x + "y=" + y);
            if (!(x > 0 && x < 1000 && y > 0 && y < 750 && isLive)) {
                System.out.println("子弹线程退出");
                isLive = false;
                break;
            }
//            drawBullet(x, y)
        }

    }
}