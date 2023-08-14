package com.jixs.spi;

import java.time.LocalDateTime;

/**
 * 说明
 *
 * @author jixs
 * @date 2022-05-19 14:46
 */
public class SPIInterfaceImpl implements SPIInterface{
    @Override
    public String handle() {
        return "当前时间为: " + LocalDateTime.now();
    }
}
