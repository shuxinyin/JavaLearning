package com.learn.tankgame;

import javax.swing.*;

/**
 * @author 韩顺平
 * @version 1.0
 */
public class TankGame01 extends JFrame {

    //定义MyPanel
    MyPanel mp = null;

    public static void main(String[] args) {

        TankGame01 TankGame01 = new TankGame01();
    }

    public TankGame01() {
        mp = new MyPanel();
        Thread thread = new Thread(mp);
        thread.start();

        this.add(mp);//把面板(就是游戏的绘图区域)
        this.setSize(1000, 750);
        this.addKeyListener(mp);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }
}
