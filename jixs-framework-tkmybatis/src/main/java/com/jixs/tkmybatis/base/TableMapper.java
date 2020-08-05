package com.jixs.tkmybatis.base;

import tk.mybatis.mapper.annotation.RegisterMapper;
import tk.mybatis.mapper.common.ExampleMapper;
import tk.mybatis.mapper.common.Marker;
import tk.mybatis.mapper.common.RowBoundsMapper;
import tk.mybatis.mapper.common.base.BaseDeleteMapper;
import tk.mybatis.mapper.common.base.BaseSelectMapper;
import tk.mybatis.mapper.common.base.insert.InsertSelectiveMapper;
import tk.mybatis.mapper.common.base.update.UpdateByPrimaryKeySelectiveMapper;

/**
 * TableMapper，单表都继承此TableMapper.
 *
 * @author zhangfs
 */
@RegisterMapper
public interface TableMapper<T> extends
        BaseSelectMapper<T>,
        InsertSelectiveMapper<T>,
        UpdateByPrimaryKeySelectiveMapper<T>,
        BaseDeleteMapper<T>,
        ExampleMapper<T>,
        RowBoundsMapper<T>,
        InsertListMapper<T>,
        Marker {

}
