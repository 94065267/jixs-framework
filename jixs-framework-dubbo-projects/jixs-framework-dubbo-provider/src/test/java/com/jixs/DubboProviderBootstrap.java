package com.jixs;

import com.alibaba.dubbo.spring.boot.annotation.EnableDubboConfiguration;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

/**
 * 服务工程启动类
 *
 * @author jixs
 * @date 2019/5/18
 */
@SpringBootApplication
@EnableDubboConfiguration
public class DubboProviderBootstrap {
    public static void main(String[] args) throws InterruptedException {
        new SpringApplicationBuilder(DubboProviderBootstrap.class).web(WebApplicationType.NONE).run(args);
        Thread.currentThread().join();
    }
}
