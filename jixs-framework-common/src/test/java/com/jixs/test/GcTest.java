package com.jixs.test;

/**
 * 类说明
 *
 * @author jixs
 * @date 2020-08-24
 */
public class GcTest {
    private static final int _1MB = 1024 * 1024;

    public static void main(String[] args) {
        //java -verbose[:class|gc|jni] 在输出设备上显示虚拟机运行信息。
        //-verbose:gc -Xms20M -Xmx20M -Xmn10M -XX:+PrintGCDetails -XX:SurvivorRatio=8
        byte[] a1, a2, a3, a4, a5, a6, a7, a8;
        a1 = new byte[2 * _1MB];
        a2 = new byte[2 * _1MB];
        a3 = new byte[2 * _1MB];
        a4 = new byte[2 * _1MB];//第一次发生GC
        a5 = new byte[2 * _1MB];
        a6 = new byte[2 * _1MB];
        a7 = new byte[2 * _1MB];//第二次
        a8 = new byte[2 * _1MB];
    }
}
