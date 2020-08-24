package com.jixs.tkmybatis.base;

import org.apache.ibatis.annotations.InsertProvider;
import tk.mybatis.mapper.additional.insert.InsertListProvider;
import tk.mybatis.mapper.annotation.RegisterMapper;

import java.util.List;

/**
 * 通用Mapper接口, 批量插入，支持批量插入的数据库都可以使用，例如mysql,h2等
 *
 * @param <T> 不能为空
 * @author whitr
 * @version 2018.07.02
 * @create 2018-07-02 10:24
 */
@RegisterMapper
public interface InsertListMapper<T> {

    /**
     * 批量插入，支持批量插入的数据库可以使用，例如MySQL,H2等
     *
     * @param recordList
     * @return
     */
    @InsertProvider(type = InsertListProvider.class, method = "dynamicSQL")
    int insertList(List<T> recordList);

}
