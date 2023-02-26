package com.learn.QQ.QQClient.view;


import com.learn.QQ.QQClient.service.UserClientService;
import com.learn.QQ.QQClient.utils.Utility;

/**
 * @author 韩顺平
 * @version 1.0
 * 客户端的菜单界面
 */
public class QQView {

    private boolean loop = true; //控制是否显示菜单
    private String key = ""; // 接收用户的键盘输入
    UserClientService userClientService = new UserClientService();

    public static void main(String[] args) {
        new QQView().mainMenu();
        System.out.println("客户端退出系统.....");
    }

    //显示主菜单
    private void mainMenu() {

        while (loop) {

            System.out.println("===========欢迎登录网络通信系统===========");
            System.out.println("\t\t 1 登录系统");
            System.out.println("\t\t 9 退出系统");
            System.out.print("请输入你的选择: ");
            key = Utility.readString(1);

            //根据用户的输入，来处理不同的逻辑
            switch (key) {
                case "1":
                    System.out.print("请输入用户号: ");
                    String userId = Utility.readString(50);
                    System.out.print("请输入密  码: ");
                    String pwd = Utility.readString(50);
                    //这里就比较麻烦了, 需要到服务端去验证该用户是否合法
                    //这里有很多代码, 我们这里编写一个类 UserClientService[用户登录/注册]
                    if (userClientService.checkUser(userId, pwd)) { //还没有写完, 先把整个逻辑打通....
                        System.out.println("===========欢迎 (用户 " + userId + " 登录成功) ===========");
                        //进入到二级菜单
                        while (loop) {
                            System.out.println("\n=========网络通信系统二级菜单(用户 " + userId + " )=======");
                            System.out.println("\t\t 1 显示在线用户列表");
                            System.out.println("\t\t 2 群发消息");
                            System.out.println("\t\t 3 私聊消息");
                            System.out.println("\t\t 4 发送文件");
                            System.out.println("\t\t 9 退出系统");
                            System.out.print("请输入你的选择: ");
                            key = Utility.readString(1);
                            switch (key) {
                                case "1":
                                case "2":
                                    String s = Utility.readString(50);
                                    break;
                                case "3":
                                    System.out.print("请输入想聊天的用户号(在线): ");
                                    String getterId = Utility.readString(50);
                                    System.out.print("请输入想说的话: ");
                                    String content = Utility.readString(100);
                                    //编写一个方法，将消息发送给服务器端
                                    break;
                                case "4":
                                    getterId = Utility.readString(50);
                                    String src = Utility.readString(100);
                                    String dest = Utility.readString(100);
                                    break;
                                case "9":
                                    //调用方法，给服务器发送一个退出系统的message
                                    loop = false;
                                    break;
                            }

                        }
                    } else { //登录服务器失败
                        System.out.println("=========登录失败=========");
                    }
                    break;
                case "9":
                    loop = false;
                    break;
            }

        }

    }
}
