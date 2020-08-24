package com.jixs.framework.dubbo.consumer;

import com.alibaba.dubbo.config.annotation.Reference;
import com.alibaba.dubbo.config.annotation.Service;
import com.jixs.framework.dubbo.api.UserService;

/**
 * 类说明
 *
 * @author jixs
 * @date 2020-08-21
 */
@Service
public class ConsumerService {
    @Reference
    private UserService userService;

    public String getNameById(String userId) {
        return userService.getNameById(userId);
    }
}
