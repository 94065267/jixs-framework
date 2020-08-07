package com.jixs.mybatis.thread;

import com.jixs.common.util.SpringUtil;
import com.jixs.mybatis.busi.User;
import com.jixs.mybatis.po.TUser;
import lombok.Getter;
import lombok.Setter;
import lombok.SneakyThrows;

/**
 * @author: jixs
 * @date: 2020-08-06
 */
@Getter
@Setter
public class UserThread extends Thread {
    private final User user = SpringUtil.getBean(User.class);
    private TUser tUser;
    private String threadId;

    public UserThread(TUser tUser, String threadId) {
        this.tUser = tUser;
        this.threadId = threadId;
    }

    @SneakyThrows
    @Override
    public  void run() {
        user.add(tUser);
    }
}
