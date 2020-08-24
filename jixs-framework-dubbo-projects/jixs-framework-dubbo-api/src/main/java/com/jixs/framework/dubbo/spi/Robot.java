package com.jixs.framework.dubbo.spi;

import com.alibaba.dubbo.common.extension.SPI;

/**
 * dubbo SPI接口
 */
@SPI
public interface Robot {
    void sayHello();
}
