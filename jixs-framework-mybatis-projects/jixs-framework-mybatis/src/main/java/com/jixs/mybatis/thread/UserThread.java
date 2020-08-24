package com.jixs.mybatis.thread;

import com.jixs.common.util.SpringUtil;
import com.jixs.mybatis.busi.User;
import com.jixs.mybatis.po.TUser;
import lombok.Getter;
import lombok.Setter;
import lombok.SneakyThrows;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author: jixs
 * @date: 2020-08-06
 */
@Getter
@Setter
public class UserThread extends Thread {
    public static volatile int counter = 0;
    private final User user = SpringUtil.getBean(User.class);
    private TUser tUser;
    private String threadId;

    public UserThread(TUser tUser, String threadId) {
        this.tUser = tUser;
        this.threadId = threadId;
    }

    @SneakyThrows
    @Override
    public void run() {
        user.add(tUser);
    }

    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            Thread a = new Thread(() -> {
                for (int j = 0; j < 10; j++) {
                    counter++;
                }
            });
            a.start();
        }

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("counter = " + counter);
    }
}
