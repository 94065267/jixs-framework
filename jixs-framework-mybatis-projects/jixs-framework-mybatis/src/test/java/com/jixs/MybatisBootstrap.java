package com.jixs;

import com.jixs.mybatis.po.TUser;
import com.jixs.mybatis.thread.UserThread;
import org.assertj.core.util.DateUtil;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

import java.util.Random;

/**
 * 服务工程启动类
 *
 * @author jixs
 * @date 2019/5/18
 */
@SpringBootApplication
public class MybatisBootstrap {
    public static void main(String[] args) throws InterruptedException {
        new SpringApplicationBuilder(MybatisBootstrap.class).web(WebApplicationType.NONE).run(args);
        Thread.currentThread().join();

//        System.out.println(String.format("%04d", 10));

//        for (int i = 0; i < 5; i++) {
//            TUser user = new TUser();
//            Random ran = new Random();
//            String id = String.valueOf(System.currentTimeMillis()) + ran.nextInt(1000000);
//            user.setUserId(id);
//            user.setUserName("2020080601");
//            user.setUserCode("2020080601");
//            user.setUserSex(0);
//            user.setUserAddress("2020080601");
//            user.setUserTel("2020080601");
//            user.setNote("2020080601");
//            user.setCreateTime(DateUtil.now());
//            UserThread userThread = new UserThread(user, id);
//            userThread.start();
//        }
    }
}
