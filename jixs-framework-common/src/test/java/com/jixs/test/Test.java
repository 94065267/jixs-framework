package com.jixs.test;

/**
 * 说明
 *
 * @author jixs
 * @date 2021-12-21 11:30
 */
public class Test {
    public static void main(String[] args) {
        int sum = 0;
        for (int i = 1; i <= 32; i++) {
            sum = sum + i;
        }
        System.out.print("sum=" + sum);
    }
}
