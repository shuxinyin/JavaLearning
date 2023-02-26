package com.learn.QQ.QQServer.qqframe;


import com.learn.QQ.QQServer.qqserver.service.QQServer;

/**
 * @author shuxy
 * @version 1.0
 * 该类创建QQServer ,启动后台的服务
 */
public class QQFrame {
    public static void main(String[] args)  {
        new QQServer();
    }
}
