package com.pluralsight.config;


import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
public class DbConfiguration {


    private BasicDataSource dataSource;


    @Bean
    public DataSource dataSource(@Value("${spring.datasource.url}") String url, @Value("${spring.datasource.username}") String username, @Value("${spring.datasource.password}") String password) {
        BasicDataSource dataSource = new BasicDataSource();

        dataSource.setUrl(url);
        dataSource.setUsername(username);
        dataSource.setPassword(password);
        dataSource.setInitialSize(2);
        dataSource.setMaxTotal(5);
        dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
        return dataSource;

    }


}
