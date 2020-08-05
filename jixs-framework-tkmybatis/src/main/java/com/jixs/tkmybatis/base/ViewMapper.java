package com.jixs.tkmybatis.base;

import tk.mybatis.mapper.annotation.RegisterMapper;
import tk.mybatis.mapper.common.RowBoundsMapper;
import tk.mybatis.mapper.common.base.BaseSelectMapper;
import tk.mybatis.mapper.common.example.SelectByExampleMapper;
import tk.mybatis.mapper.common.example.SelectCountByExampleMapper;

/**
 * 视图ViewMapper, 只有视图或自定义关联查询时才继承此接口.
 *
 * @author Zhangfs
 */
@RegisterMapper
public interface ViewMapper<T> extends BaseSelectMapper<T>,
        SelectByExampleMapper<T>, SelectCountByExampleMapper<T>,
        RowBoundsMapper<T> {
}
