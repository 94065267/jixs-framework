package com.jixs.mybatis.plugin;

import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.executor.Executor;
import org.apache.ibatis.executor.parameter.ParameterHandler;
import org.apache.ibatis.executor.resultset.ResultSetHandler;
import org.apache.ibatis.executor.statement.StatementHandler;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.plugin.*;
import org.springframework.stereotype.Component;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.Properties;

/**
 * 查询插件
 *
 * @author: jixs
 * @date: 2020-08-05
 */
@Slf4j
//@Component
@Intercepts({
        @Signature(type = Executor.class, method = "update", args = {MappedStatement.class, Object.class})
        , @Signature(type = StatementHandler.class, method = "prepare", args = {Connection.class, Integer.class})
        , @Signature(type = ParameterHandler.class, method = "setParameters", args = {PreparedStatement.class})
        , @Signature(type = ResultSetHandler.class, method = "handleResultSets", args = {Statement.class})
})
public class ExecutorInterceptor implements Interceptor {
    Properties prop = null;

    /**
     * 代替拦截对象的方法的内容
     *
     * @param invocation 责任链对象
     * @return
     * @throws Throwable
     */
    @Override
    public Object intercept(Invocation invocation) throws Throwable {
        log.info("intercept -> before。。。。。。。。。。。。。。。");
        Object object = invocation.proceed();
        log.info("intercept -> after。。。。。。。。。。。。。。。");
        return object;
    }

    @Override
    public Object plugin(Object target) {
        log.info("plugin -> 调用生成代理对象。。。。。。。。。。。。。。。");
        return Plugin.wrap(target, this);
    }

    @Override
    public void setProperties(Properties properties) {
        log.info("setProperties -> dbType={}", properties.get("dbType"));
        this.prop = properties;
    }
}
