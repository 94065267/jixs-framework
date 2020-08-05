package com.jixs.mybatis.typehandler;

import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.MappedJdbcTypes;
import org.apache.ibatis.type.MappedTypes;

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
@MappedTypes(SexEnum.class)
public class EnumTypeHandler<T extends BaseEnum<T>> extends BaseTypeHandler<T> {
    private Class<T> type;
    private T[] enums;

    public EnumTypeHandler(Class<T> type) {
        if (type == null) {
            throw new IllegalArgumentException("Type argument cannot be null");
        }
        this.type = type;
        this.enums = type.getEnumConstants();

    }

    @Override
    public void setNonNullParameter(PreparedStatement ps, int i, T parameter, JdbcType jdbcType) throws SQLException {
        ps.setInt(i, parameter.getId());
    }

    @Override
    public T getNullableResult(ResultSet rs, String columnName) throws SQLException {
        return getEnumByOrdinal(rs.getInt(columnName));
    }

    @Override
    public T getNullableResult(ResultSet rs, int columnIndex) throws SQLException {
        return getEnumByOrdinal(rs.getInt(columnIndex));
    }

    @Override
    public T getNullableResult(CallableStatement cs, int columnIndex) throws SQLException {
        return getEnumByOrdinal(cs.getInt(columnIndex));
    }


    private T getEnumByOrdinal(int ordinal) {
        for (T t : enums) {
            if (t.getId() == ordinal) {
                return t;
            }
        }
        return null;
    }

}
