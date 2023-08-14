package com.jixs.test;

import com.jixs.spi.SPIInterface;

import java.util.ServiceLoader;

/**
 * 说明
 *
 * @author jixs
 * @date 2021-12-21 11:30
 */
public class Test {
    public static void main(String[] args) {
        ServiceLoader<SPIInterface> load = ServiceLoader.load(SPIInterface.class);
        for (SPIInterface ser : load) {
            System.out.println(ser.handle());
        }
    }
}
