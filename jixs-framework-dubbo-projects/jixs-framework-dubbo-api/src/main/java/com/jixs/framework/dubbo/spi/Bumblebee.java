package com.jixs.framework.dubbo.spi;

/**
 * 类说明
 *
 * @author jixs
 * @date 2020-08-21
 */
public class Bumblebee implements Robot {

    @Override
    public void sayHello() {
        System.out.println("Hello, I am Bumblebee.");
    }
}
