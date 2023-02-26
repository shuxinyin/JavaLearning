package com.learn.tankgame;


import java.util.Vector;

public class EnemyTank extends Tank implements Runnable {
    Vector<Shot> shots = new Vector<>();
    boolean isLive = true;

    public EnemyTank(int x, int y) {
        super(x, y);
    }


    @Override
    public void run() {

        while (true) {
            if (isLive && shots.size() < 1) {
                Shot s = null;
                switch (getDirect()) {
                    case 0:  // 上
                        s = new Shot(getX() + 20, getY(), 0);
                        break;
                    case 1:  // 右
                        s = new Shot(getX() + 60, getY() + 20, 1);
                        break;
                    case 2: // 下
                        s = new Shot(getX() + 20, getY() + 60, 2);
                        break;
                    case 3:// 左
                        s = new Shot(getX(), getY() + 20, 3);
                        break;
                }

                new Thread(s).start();
            }

        }
    }
}