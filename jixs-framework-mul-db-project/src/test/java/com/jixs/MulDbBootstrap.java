package com.jixs;

import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

/**
 * 说明
 *
 * @author jixs
 * @date 2021-12-15 11:13
 */
@SpringBootApplication
public class MulDbBootstrap {
    public static void main(String[] args) throws InterruptedException {
        new SpringApplicationBuilder(MulDbBootstrap.class).web(WebApplicationType.NONE).run(args);
        Thread.currentThread().join();
    }
}
