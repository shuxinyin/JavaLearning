package com.learn.tankgame;



public class Hero extends Tank {
    Shot shot;

    public Shot getShot() {
        return shot;
    }

    public Hero(int x, int y) {
        super(x, y);
    }



    public void shotEnemyTank() {
        switch (getDirect()) {
            case 0:  // 上
                shot = new Shot(getX() + 20, getY(), 0);
                break;
            case 1:  // 右
                shot = new Shot(getX() + 60, getY() + 20, 1);
                break;
            case 2: // 下
                shot = new Shot(getX() + 20, getY() + 60, 2);
                break;
            case 3:// 左
                shot = new Shot(getX(), getY() + 20, 3);
                break;
        }

        new Thread(shot).start();

    }
}
