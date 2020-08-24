package com.jixs.framework.dubbo.api;

/**
 * 用户接口
 */
public interface UserService {
    /**
     * 根据用户id查询用户名称
     *
     * @param userId
     * @return
     */
    String getNameById(String userId);
}
