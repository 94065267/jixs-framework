package com.jixs.mybatis.mapper;

import com.jixs.mybatis.po.TUser;
import org.apache.ibatis.session.RowBounds;

import java.util.List;

/**
 * @author jixs
 */
public interface TUserMapper {
    /**
     * 根据主键查询
     *
     * @param userId 用户id
     * @return 用户信息
     */
    TUser selectByPrimaryKey(String userId);

    /**
     * 查询 带所有条件
     *
     * @param user 用户信息
     * @return 用户列表
     */
    List<TUser> select(TUser user);

    /**
     * 查询 带所有条件带分页
     *
     * @param user      用户信息
     * @param rowBounds 分页
     * @return 用户列表
     */
    List<TUser> select(TUser user, RowBounds rowBounds);

    /**
     * 根据主键删除
     *
     * @param userId 用户id
     * @return 删除数量
     */
    int deleteByPrimaryKey(String userId);

    /**
     * 新增
     *
     * @param record 用户信息
     * @return 插入数量
     */
    int insert(TUser record);

    /**
     * 根据主键更新
     *
     * @param record 用户信息
     * @return 更新数量
     */
    int updateByPrimaryKey(TUser record);
}