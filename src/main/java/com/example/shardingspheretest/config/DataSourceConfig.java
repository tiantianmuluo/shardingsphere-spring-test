package com.example.shardingspheretest.config;

import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;

@Configuration
public class DataSourceConfig {
    @Value("${spring.shardingsphere.datasource.ds-0.jdbc-url}")
    private String url;
    @Value("${spring.shardingsphere.datasource.ds-0.driver-class-name}")
    private String driver;
    @Value("${spring.shardingsphere.datasource.ds-0.username}")
    private String userName;
    @Value("${spring.shardingsphere.datasource.ds-0.password}")
    private String password;

    @Bean
    @Primary
    public DataSource dataSource(@Qualifier("shardingSphereDataSource") DataSource dataSource) {
        return dataSource;
    }

    @Bean(name = "testDataSource")
    public DataSource dataSource() {
        DruidDataSource druidDataSource = new DruidDataSource();
        druidDataSource.setUrl(url);
        druidDataSource.setDriverClassName(driver);
        druidDataSource.setUsername(userName);
        druidDataSource.setPassword(password);
        return druidDataSource;
    }

    @Bean(name = "testJdbcTemplate")
    public JdbcTemplate jdbcTemplate(@Qualifier("testDataSource") DataSource dataSource) {
        JdbcTemplate jdbcTemplate = new JdbcTemplate();
        jdbcTemplate.setDataSource(dataSource);
        return jdbcTemplate;
    }
}
