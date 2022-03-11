package com.jixs.framework.dubbo.provider;

import com.alibaba.dubbo.config.annotation.Service;
import com.jixs.framework.dubbo.api.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * 类说明
 *
 * @author jixs
 * @date 2020-08-21
 */
@Slf4j
@Service(interfaceClass = UserService.class, group = "groupUser")
@Component
public class GroupUserServiceImpl implements UserService {
    @Override
    public String getNameById(String userId) {
        log.info("入参userId={}", userId);
        return userId + "的姓名就是group-" + userId;
    }
}
