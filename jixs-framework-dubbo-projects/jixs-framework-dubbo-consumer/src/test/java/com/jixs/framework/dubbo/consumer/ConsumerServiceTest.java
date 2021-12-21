package com.jixs.framework.dubbo.consumer;

import com.alibaba.dubbo.config.annotation.Reference;
import com.jixs.DubboConsumerBootstrap;
import com.jixs.framework.dubbo.api.UserService;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@Slf4j
@SpringBootTest(classes = DubboConsumerBootstrap.class)
@RunWith(SpringRunner.class)
public class ConsumerServiceTest {
    @Reference(url = "dubbo://localhost:20880", group = "groupUser")
    private UserService userService;

    @Test
    public void test() {
        String name = userService.getNameById("jixs");
        log.info("name = {}", name);
    }

}