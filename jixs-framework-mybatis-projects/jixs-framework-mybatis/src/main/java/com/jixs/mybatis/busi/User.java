package com.jixs.mybatis.busi;

import com.jixs.mybatis.mapper.TUserMapper;
import com.jixs.mybatis.po.TUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import java.util.List;

/**
 * @author: jixs
 * @date: 2020-08-06
 */
@Component
public class User {
    @Autowired
    private TUserMapper tUserMapper;

    /**
     * 新增用户
     *
     * @param tUser
     */
    public synchronized void add(TUser tUser) throws Exception {
        TUser tUserParam = new TUser();
        tUserParam.setUserCode(tUser.getUserCode());
        List<TUser> users = tUserMapper.select(tUserParam);
        if (!CollectionUtils.isEmpty(users) && users.size() > 1) {
            throw new Exception(tUser.getUserId() + ",该" + tUser.getUserCode() + "的用户大于1个，有问题");
        } else if (CollectionUtils.isEmpty(users)) {
            tUserMapper.insert(tUser);
        } else if (!CollectionUtils.isEmpty(users) && users.size() == 1) {
            System.out.println("userId = " + users.get(0).getUserId());
        }
    }
}
