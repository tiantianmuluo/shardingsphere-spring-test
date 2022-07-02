package com.example.shardingspheretest.config;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;
/*
@Component
@Primary
public class DynamicDataSource extends AbstractRoutingDataSource {
    public static ThreadLocal<String> name = new ThreadLocal<>();

    @Autowired
    DataSource testDataSource;

    @Autowired
    DataSource shardingSphereDataSource;


    @Override
    protected Object determineCurrentLookupKey() {
        if (StringUtils.isEmpty(name.get())) {
            name.set("RW");
        }
        return name.get();
    }

    @Override
    public void afterPropertiesSet() {
        Map<Object, Object> targetDataSources = new HashMap<>();
        targetDataSources.put("RW", shardingSphereDataSource);
        targetDataSources.put("R", testDataSource);
        super.setTargetDataSources(targetDataSources);
        super.setDefaultTargetDataSource(shardingSphereDataSource);
        super.afterPropertiesSet();
    }
}*/
