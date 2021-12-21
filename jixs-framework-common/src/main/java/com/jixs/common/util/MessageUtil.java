package com.jixs.common.util;

import java.awt.*;
import java.awt.event.KeyEvent;

/**
 * @author whitr
 * @version 2018.11.20
 * @create 2018-11-20 10:50
 */
public class MessageUtil {
    /**
     * @param count 设置轰炸的次数
     * @param time  设置每次循环的间隔时间(ms)
     * @throws AWTException
     */
    public static void send(int count, int time) throws AWTException {
        Robot robot = new Robot();
        //使用这个程序必须先将轰炸的内容复制好然后打开聊天框
        //所以预留5秒做准备
        System.out.println("复制好内容打开聊天框五秒后进行轰炸");
        for (int i = 5; i > 0; i--) {
            System.out.println(i + "秒");
            robot.delay(1000);
        }
        System.out.println("开始");
        for (int i = 0; i < count; i++) {
            //同时按下ctrl+v粘贴好 然后在同时释放ctrl+v，模拟粘贴键。
            robot.keyPress(KeyEvent.VK_CONTROL);
            robot.keyPress(KeyEvent.VK_V);
            robot.keyRelease(KeyEvent.VK_CONTROL);
            robot.keyRelease(KeyEvent.VK_V);
            //让轰炸有间隔的进行
            robot.delay(time);
            //按下回车让信息发送，模拟enter键
            robot.keyPress(KeyEvent.VK_ENTER);
            robot.keyRelease(KeyEvent.VK_ENTER);
        }
    }

    public static void main(String[] args) throws AWTException {
        MessageUtil.send(50, 1000);
    }
}
