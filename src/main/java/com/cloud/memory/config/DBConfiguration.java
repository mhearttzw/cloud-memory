/*
package com.cloud.memory.config;

import com.zaxxer.hikari.HikariDataSource;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.transaction.ChainedTransactionManager;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;

import javax.sql.DataSource;

*/
/**
 * @author           echelon
 * @email            2954632969@qq.com
 * @created_time     2018/10/7 17:26
 * @description      多数据源自定义配置
 *//*

@Configuration
public class DBConfiguration {

    */
/**
     * 读取数据库配置并将其储存到DataSourceProperties对象中
     * @return
     *//*

    @Bean
    @Primary
    @ConfigurationProperties(prefix = "spring.ds_user")
    public DataSourceProperties userDataSourceProperties() {
        return new DataSourceProperties();
    }

    @Bean(name = "userDataSource")
    @Primary
    public DataSource userDataSource() {
        return userDataSourceProperties().initializeDataSourceBuilder().type(HikariDataSource.class).build();
    }

    @Bean
    public JdbcTemplate userJdbcTemplate(@Qualifier("userDataSource") DataSource userDataSource) {
        return new JdbcTemplate(userDataSource);
    }

    @Bean
    public PlatformTransactionManager transactionManager() {
        // 下面两行代码不是简单的方法调用，而是从容器里面获取
        DataSourceTransactionManager userTM = new DataSourceTransactionManager(userDataSource());
        DataSourceTransactionManager orderTM =new DataSourceTransactionManager(orderDataSource());
        ChainedTransactionManager tm = new ChainedTransactionManager(userTM, orderTM);
        return tm;
    }

    // order数据源配置
    @Bean(name = "orderDataSource")
    @Primary
    @ConfigurationProperties(prefix = "spring.ds_order")
    public DataSource orderDataSource() {
        return DataSourceBuilder.create().type(HikariDataSource.class).build();
    }

    @Bean
    public JdbcTemplate orderJdbcTemplate(@Qualifier("orderDataSource") DataSource orderDataSource) {
        return new JdbcTemplate(orderDataSource);
    }

}
*/
