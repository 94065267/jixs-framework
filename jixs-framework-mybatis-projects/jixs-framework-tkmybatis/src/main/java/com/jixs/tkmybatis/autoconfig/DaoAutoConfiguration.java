package com.jixs.tkmybatis.autoconfig;

import org.apache.ibatis.mapping.DatabaseIdProvider;
import org.apache.ibatis.mapping.VendorDatabaseIdProvider;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.springframework.boot.autoconfigure.AutoConfigureBefore;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import tk.mybatis.mapper.autoconfigure.MapperAutoConfiguration;
import tk.mybatis.mapper.autoconfigure.MybatisProperties;
import tk.mybatis.spring.annotation.MapperScan;

import javax.sql.DataSource;
import java.util.Properties;

/**
 * DaoAutoConfiguration
 *
 * @author whitr
 * @version 2018.04.19
 * @create 2018-04-19 16:54
 */
@Configuration
@MapperScan(basePackages = "com.jixs.**.mapper")
@ConditionalOnClass({SqlSessionFactory.class, SqlSessionFactoryBean.class, DataSource.class})
@AutoConfigureBefore(MapperAutoConfiguration.class)
public class DaoAutoConfiguration {

    @Bean
    @Primary
    public MybatisProperties bspMybatisProperties() {
        MybatisProperties properties = new MybatisProperties();
        properties.setMapperLocations(new String[]{"classpath*:mapper/*.xml"});
        properties.setTypeAliasesPackage("com.jixs.**.po");
        return properties;
    }

    @Bean
    public DatabaseIdProvider databaseIdProvider() {
        DatabaseIdProvider databaseIdProvider = new VendorDatabaseIdProvider();
        Properties properties = new Properties();
        properties.setProperty("Oracle", "oracle");
        properties.setProperty("MySQL", "mysql");
        properties.setProperty("DB2", "db2");
        properties.setProperty("Derby", "derby");
        properties.setProperty("H2", "h2");
        properties.setProperty("HSQL", "hsql");
        properties.setProperty("Informix", "informix");
        properties.setProperty("MS-SQL", "ms-sql");
        properties.setProperty("PostgreSQL", "postgresql");
        properties.setProperty("Sybase", "sybase");
        properties.setProperty("Hana", "hana");
        databaseIdProvider.setProperties(properties);
        return databaseIdProvider;
    }
}