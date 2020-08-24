package com.jixs.mybatis.typehandler;

import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.TypeHandler;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * 自定义枚举类处理器
 *
 * @author: jixs
 * @date: 2020-08-03
 */
@Slf4j
public class SexEnumTypeHandler implements TypeHandler<SexEnum> {

    /**
     * 入参设置转换
     *
     * @param ps        预编译
     * @param i         参数索引
     * @param parameter 参数
     * @param jdbcType  数据库类型
     * @throws SQLException 异常
     */
    @Override
    public void setParameter(PreparedStatement ps, int i, SexEnum parameter, JdbcType jdbcType) throws SQLException {
        log.info("性别枚举类自定义处理器,性别参数设置。。。。。。。。。。。。。。。。。。");
        ps.setInt(i, parameter.getId());
    }

    /**
     * 返回处理
     *
     * @param rs         结果集
     * @param columnName 列明
     * @return 性别枚举类
     * @throws SQLException 异常
     */
    @Override
    public SexEnum getResult(ResultSet rs, String columnName) throws SQLException {
        log.info("性别枚举类自定义处理器,性别返回值设置。。。。。。。。。。。。。。。。。。");
        return SexEnum.getSexEnumById(rs.getInt(columnName));
    }

    /**
     * 返回处理
     *
     * @param rs          结果集
     * @param columnIndex 结果索引
     * @return 性别枚举类
     * @throws SQLException 异常
     */
    @Override
    public SexEnum getResult(ResultSet rs, int columnIndex) throws SQLException {
        log.info("性别枚举类自定义处理器,性别返回值设置。。。。。。。。。。。。。。。。。。");
        return SexEnum.getSexEnumById(rs.getInt(columnIndex));
    }

    /**
     * 返回处理
     *
     * @param cs          存储过程
     * @param columnIndex 结果索引
     * @return 性别枚举类
     * @throws SQLException 异常
     */
    @Override
    public SexEnum getResult(CallableStatement cs, int columnIndex) throws SQLException {
        log.info("性别枚举类自定义处理器,性别返回值设置。。。。。。。。。。。。。。。。。。");
        return SexEnum.getSexEnumById(cs.getInt(columnIndex));
    }
}
