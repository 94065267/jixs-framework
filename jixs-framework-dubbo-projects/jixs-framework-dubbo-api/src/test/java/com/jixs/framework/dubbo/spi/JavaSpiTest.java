package com.jixs.framework.dubbo.spi;

import java.util.ServiceLoader;

/**
 * @author: jixs
 * @date: 2020-08-14
 */
public class JavaSpiTest {
    public static void main(String[] args) {
        ServiceLoader<Robot> serviceLoader = ServiceLoader.load(Robot.class);
        System.out.println("Java SPI");
        serviceLoader.forEach(Robot::sayHello);
    }
}