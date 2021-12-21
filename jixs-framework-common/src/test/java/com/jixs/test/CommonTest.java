package com.jixs.test;

/**
 * 公共测试类
 *
 * @author jixs
 * @date 2020-08-24
 */
public class CommonTest {
    public static void main(String[] args) {
        System.out.println("java.version = " + System.getProperty("java.version"));
        System.out.println("java.vendor = " + System.getProperty("java.vendor"));
        System.out.println("java.home = " + System.getProperty("java.home"));
        System.out.println("java.class.version = " + System.getProperty("java.class.version"));
        System.out.println("java.class.path = " + System.getProperty("java.class.path"));
    }
}
