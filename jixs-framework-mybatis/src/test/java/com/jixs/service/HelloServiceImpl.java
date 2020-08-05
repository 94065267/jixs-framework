package com.jixs.service;

import lombok.extern.slf4j.Slf4j;

/**
 * @author: jixs
 * @date: 2020-07-29
 */
@Slf4j
public class HelloServiceImpl implements IHelloService {
    @Override
    public void sayHello(String name) {
        log.info("Hello,{}!", name);
    }
}
