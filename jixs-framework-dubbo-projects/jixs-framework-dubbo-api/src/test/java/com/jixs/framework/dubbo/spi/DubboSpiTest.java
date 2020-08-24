package com.jixs.framework.dubbo.spi;

import com.alibaba.dubbo.common.extension.ExtensionLoader;

/**
 * @author: jixs
 * @date: 2020-08-14
 */
public class DubboSpiTest {
    public static void main(String[] args) {

        ExtensionLoader<Robot> extensionLoader = ExtensionLoader.getExtensionLoader(Robot.class);
        System.out.println("Dubbo SPI");
        Robot optimusPrime = extensionLoader.getExtension("optimusPrime");
        optimusPrime.sayHello();
        Robot bumblebee = extensionLoader.getExtension("bumblebee");
        bumblebee.sayHello();
    }

}
