package com.jixs.spi;

import java.time.LocalDateTime;
import java.util.Date;

/**
 * 说明
 *
 * @author jixs
 * @date 2022-05-19 14:47
 */
public class SPIInterfaceImpla implements SPIInterface{
    @Override
    public String handle() {
        return "啊当前时间为: " + new Date();
    }
}
