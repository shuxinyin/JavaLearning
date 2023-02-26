package com.learn.tankgame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Vector;

//为了监听 键盘事件， 实现KeyListener
public class MyPanel extends JPanel implements KeyListener, Runnable {
    //定义我的坦克
    Hero hero = null;
    //定义敌人坦克，放入到Vector
    Vector<EnemyTank> enemyTanks = new Vector<>();
    //定义一个Vector，用于存放炸弹： 当子弹击中坦克时候， 加入一个Bomb对象到bombs中
    Vector<Bomb> bombs = new Vector<>();

    int enemyTankSize = 3;

    //定义三张爆炸图片
    Image image1 = null;
    Image image2 = null;
    Image image3 = null;

    public MyPanel() {
        hero = new Hero(100, 100);//初始化自己坦克
        //初始化敌人坦克
        for (int i = 0; i < enemyTankSize; i++) {
            //创建一个敌人的坦克
            EnemyTank enemyTank = new EnemyTank((100 * (i + 1)), 0);
            //设置方向
            enemyTank.setDirect(2);

            //给该enemyTank 加入一颗子弹
            Shot shot = new Shot(enemyTank.getX() + 20, enemyTank.getY() + 60, enemyTank.getDirect());
            //加入enemyTank的Vector 成员
            enemyTank.shots.add(shot);
            //启动 shot 对象
            new Thread(shot).start();

            //加入
            enemyTanks.add(enemyTank);
        }

        // 初始化图片
        image1 = Toolkit.getDefaultToolkit().getImage(Panel.class.getResource("/bomb_1.gif"));
        image2 = Toolkit.getDefaultToolkit().getImage(Panel.class.getResource("/bomb_2.gif"));
        image3 = Toolkit.getDefaultToolkit().getImage(Panel.class.getResource("/bomb_3.gif"));

        Bomb bomb =new Bomb(0, 0);
        bombs.add(bomb);

    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        g.fillRect(0, 0, 1000, 750);//填充矩形，默认黑色

        //画出自己坦克-封装方法
        drawTank(hero.getX(), hero.getY(), g, hero.getDirect(), 1);

        // 画子弹
        if (hero.getShot() != null && hero.getShot().isLive == true) {
            drawBullet(hero.getShot().x, hero.getShot().y, g);
        }

        // 如果bombs集合中有对象， 就画出
        for (int i = 0; i <bombs.size() ; i++) {
            Bomb bomb = bombs.get(i);  // 取出炸弹
            if (bomb.life > 6){
                g.drawImage(image1, bomb.x, bomb.y, 60, 60, this);
            } else if (bomb.life > 3){
                g.drawImage(image2, bomb.x, bomb.y, 60, 60, this);
            } else {
                g.drawImage(image3, bomb.x, bomb.y, 60, 60, this);
            }
            // 炸弹的生命值减少
            bomb.lifeDown();
            if (bomb.life == 0){
                bombs.remove(bomb);
            }
        }
        //画出敌人的坦克, 遍历Vector
        for (int i = 0; i < enemyTanks.size(); i++) {
            //取出坦克
            EnemyTank enemyTank = enemyTanks.get(i);
            // 判断坦克是否活着
            if (enemyTank.isLive) {
                drawTank(enemyTank.getX(), enemyTank.getY(), g, enemyTank.getDirect(), 0);

                // 画子弹
                for (int j = 0; j < enemyTank.shots.size(); j++) {
                    // 取出子弹
                    Shot shot = enemyTank.shots.get(j);
                    // 绘制
                    if (shot.isLive) {
                        drawBullet(shot.x, shot.y, g);
                    } else {
                        // 从 vector 移除
                        enemyTank.shots.remove(shot);
                    }
                }
            }
        }
    }

    public void drawBullet(int x, int y, Graphics g) {
        g.draw3DRect(x, y, 1, 1, false);
    }

    public void drawTank(int x, int y, Graphics g, int direct, int type) {

        //根据不同类型坦克，设置不同颜色
        switch (type) {
            case 0: //敌人的坦克
                g.setColor(Color.cyan);
                break;
            case 1: //我的坦克
                g.setColor(Color.yellow);
                break;
        }

        //根据坦克方向，来绘制对应形状坦克
        //direct 表示方向(0: 向上 1 向右 2 向下 3 向左 )
        //
        switch (direct) {
            case 0: //表示向上
                g.fill3DRect(x, y, 10, 60, false);//画出坦克左边轮子
                g.fill3DRect(x + 30, y, 10, 60, false);//画出坦克右边轮子
                g.fill3DRect(x + 10, y + 10, 20, 40, false);//画出坦克盖子
                g.fillOval(x + 10, y + 20, 20, 20);//画出圆形盖子
                g.drawLine(x + 20, y + 30, x + 20, y);//画出炮筒
                break;
            case 1: //表示向右
                g.fill3DRect(x, y, 60, 10, false);//画出坦克上边轮子
                g.fill3DRect(x, y + 30, 60, 10, false);//画出坦克下边轮子
                g.fill3DRect(x + 10, y + 10, 40, 20, false);//画出坦克盖子
                g.fillOval(x + 20, y + 10, 20, 20);//画出圆形盖子
                g.drawLine(x + 30, y + 20, x + 60, y + 20);//画出炮筒
                break;
            case 2: //表示向下
                g.fill3DRect(x, y, 10, 60, false);//画出坦克左边轮子
                g.fill3DRect(x + 30, y, 10, 60, false);//画出坦克右边轮子
                g.fill3DRect(x + 10, y + 10, 20, 40, false);//画出坦克盖子
                g.fillOval(x + 10, y + 20, 20, 20);//画出圆形盖子
                g.drawLine(x + 20, y + 30, x + 20, y + 60);//画出炮筒
                break;
            case 3: //表示向左
                g.fill3DRect(x, y, 60, 10, false);//画出坦克上边轮子
                g.fill3DRect(x, y + 30, 60, 10, false);//画出坦克下边轮子
                g.fill3DRect(x + 10, y + 10, 40, 20, false);//画出坦克盖子
                g.fillOval(x + 20, y + 10, 20, 20);//画出圆形盖子
                g.drawLine(x + 30, y + 20, x, y + 20);//画出炮筒
                break;
            default:
                System.out.println("暂时没有处理");
        }

    }


    public void hitTank(Shot s, EnemyTank enemyTank) {
        // 判断s 击中坦克
        switch (enemyTank.getDirect()) {
            case 0:  // 坦克向上
            case 2:  // 坦克向下
                if (s.x > enemyTank.getX() && s.x < enemyTank.getX() + 40
                        && s.y > enemyTank.getY() && s.y < enemyTank.getY() + 60) {
                    s.isLive = false;
                    enemyTank.isLive = false;

                    // 创建Bomb对象， 加入到bombs集合
                    Bomb bomb =new Bomb(enemyTank.getX(), enemyTank.getY());
                    bombs.add(bomb);
                }
                break;
            case 1:  // 坦克向左
            case 3:  // 坦克向右
                if (s.x > enemyTank.getX() && s.x < enemyTank.getX() + 60
                        && s.y > enemyTank.getY() && s.y < enemyTank.getY() + 40) {
                    s.isLive = false;
                    enemyTank.isLive = false;

                    // 创建Bomb对象， 加入到bombs集合
                    Bomb bomb =new Bomb(enemyTank.getX(), enemyTank.getY());
                    bombs.add(bomb);
                }
                break;
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    //处理wdsa 键按下的情况
    @Override
    public void keyPressed(KeyEvent e) {
        System.out.println(e.getKeyCode());
        if (e.getKeyCode() == KeyEvent.VK_W) {//按下W键
            //改变坦克的方向
            hero.setDirect(0);//
            //修改坦克的坐标 y -= 1
            hero.moveUp();
        } else if (e.getKeyCode() == KeyEvent.VK_D) {//D键, 向右
            hero.setDirect(1);
            hero.moveRight();

        } else if (e.getKeyCode() == KeyEvent.VK_S) {//S键
            hero.setDirect(2);
            hero.moveDown();
        } else if (e.getKeyCode() == KeyEvent.VK_A) {//A键
            hero.setDirect(3);
            hero.moveLeft();
        }

        // 发射子弹
        if (e.getKeyCode() == KeyEvent.VK_J) {//按下J键
            hero.shotEnemyTank();

        }
        //让面板重绘
//        this.repaint();

    }

    @Override
    public void keyReleased(KeyEvent e) {

    }

    @Override
    public void run() {
        while (true) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            // 判断是否击中了坦克
            if (hero.shot != null && hero.shot.isLive) {

                // 遍历所有的敌人坦克是否被击中
                for (int i = 0; i < enemyTanks.size(); i++) {
                    EnemyTank enemyTank = enemyTanks.get(i);
                    hitTank(hero.shot, enemyTank);
                    if (!enemyTank.isLive) {
                        enemyTanks.remove(enemyTank);
                    }
                }
            }
            this.repaint();
        }
    }
}
