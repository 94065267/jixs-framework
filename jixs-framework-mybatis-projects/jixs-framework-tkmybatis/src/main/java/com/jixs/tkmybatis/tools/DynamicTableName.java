package com.jixs.tkmybatis.tools;

import tk.mybatis.mapper.entity.IDynamicTableName;

import javax.persistence.Table;
import java.util.Optional;

/**
 * 类说明
 *
 * @author jixs
 * @date 2021-03-26
 */
public abstract class DynamicTableName implements IDynamicTableName {
    @Override
    public String getDynamicTableName() {
        Table table = this.getClass().getAnnotation(Table.class);
        return table.name() + Optional.ofNullable(getSaveCode()).filter(t -> !t.isEmpty()).map(t -> "_" + t).orElse("");
    }

    /**
     * 获取分表字段
     *
     * @return
     */
    public abstract String getSaveCode();
}
