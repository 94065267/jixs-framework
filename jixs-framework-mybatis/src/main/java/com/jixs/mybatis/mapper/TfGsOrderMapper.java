package com.jixs.mybatis.mapper;


import com.jixs.mybatis.po.TfGsOrder;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

import java.util.Date;
import java.util.List;


public interface TfGsOrderMapper {
    /**
     * 单个参数是基本类型
     * 可以用param指定，
     * 可以不指定，如果不指定用的时候可以用参数名或者其他任何名都可以
     *
     * @param ordId 保障单号
     * @return
     */
    TfGsOrder qryById(String ordId);
    TfGsOrder qryByIdByPropertiesTest(@Param(value = "ordId") String ordId);

    /**
     * 备注更新
     *
     * @param ordId
     * @param note
     */
    int uptNoteById(String ordId, String note);

    /**
     * 单个参数非基本类型
     * 可以用param指定，用时指定的名.属性名
     * 可以不指定，用的时候直接取用属性名，
     *
     * @param order pojo
     * @return
     */
    List<TfGsOrder> query(TfGsOrder order);
    List<TfGsOrder> query(TfGsOrder order, RowBounds rowBounds);

    /**
     * 多个参数
     * 可以用param指定
     * 不用param指定，则按照param1，param2....方式用即可
     *
     * @param acceptStart 开始
     * @param acceptEnd   结束
     * @return
     */
    List<TfGsOrder> qryByAcceptTime(Date acceptStart, Date acceptEnd);
}