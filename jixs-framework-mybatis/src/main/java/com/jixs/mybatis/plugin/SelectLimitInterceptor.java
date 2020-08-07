package com.jixs.mybatis.plugin;

import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.executor.statement.StatementHandler;
import org.apache.ibatis.plugin.*;
import org.apache.ibatis.reflection.MetaObject;
import org.apache.ibatis.reflection.SystemMetaObject;

import java.sql.Connection;
import java.util.Properties;

/**
 * 查询限制拦截器
 *
 * @author: jixs
 * @date: 2020-08-05
 */
@Slf4j
//@Component
@Intercepts({
        @Signature(type = StatementHandler.class, method = "prepare", args = {Connection.class, Integer.class})
})
public class SelectLimitInterceptor implements Interceptor {
    //查询限制数量
    private static final int LIMIT = 100;

    @Override
    public Object intercept(Invocation invocation) throws Throwable {
        StatementHandler statementHandler = (StatementHandler) invocation.getTarget();
        MetaObject metaObject = SystemMetaObject.forObject(statementHandler);
        while (metaObject.hasGetter("h")) {
            Object object = metaObject.getValue("h");
            metaObject = SystemMetaObject.forObject(object);
        }
        while (metaObject.hasGetter("target")) {
            Object object = metaObject.getValue("target");
            metaObject = SystemMetaObject.forObject(object);
        }
        String originalSql = (String) metaObject.getValue("delegate.boundSql.sql");
        String limitSql = "select * from (" + originalSql + ") limit_table limit 0," + LIMIT;
        metaObject.setValue("delegate.boundSql.sql", limitSql);
        return invocation.proceed();
    }

    @Override
    public Object plugin(Object target) {
        log.info("SelectLimitInterceptor -> plugin。。。。。。。。。。。。。。。");
        return Plugin.wrap(target, this);
    }

    @Override
    public void setProperties(Properties properties) {

    }
}
