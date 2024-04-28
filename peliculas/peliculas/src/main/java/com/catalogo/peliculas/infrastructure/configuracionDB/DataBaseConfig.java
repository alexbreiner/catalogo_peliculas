package com.catalogo.peliculas.infrastructure.configuracionDB;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.core.env.Environment;

import javax.sql.DataSource;

@Configuration
public class DataBaseConfig {

    @Bean
    public DbSecret dbSecret(Environment env) {
        return DbSecret.builder()
                .url(env.getProperty("spring.datasource.url"))
                .username(env.getProperty("spring.datasource.username"))
                .password(env.getProperty("spring.datasource.password"))
                .driverClass(env.getProperty("spring.datasource.driver-class-name"))
                .build();
    }

    @Bean
    @Profile("dev")
    public DataSource dataSource(DbSecret dbSecret) {
        HikariConfig hikariConfig = new HikariConfig();
        hikariConfig.setJdbcUrl(dbSecret.getUrl());
        hikariConfig.setUsername(dbSecret.getUsername());
        hikariConfig.setPassword(dbSecret.getPassword());
        hikariConfig.setDriverClassName(dbSecret.getDriverClass());
        return new HikariDataSource(hikariConfig);
    }

    @Bean
    @Profile("test")
    public DataSource dataSourceTest(DbSecret dbSecret) {
        HikariConfig hikariConfig = new HikariConfig();
        hikariConfig.setJdbcUrl("jdbc:mysql://localhost:3306/catalogo_peliculas_test");
        hikariConfig.setUsername(dbSecret.getUsername());
        hikariConfig.setPassword(dbSecret.getPassword());
        hikariConfig.setDriverClassName(dbSecret.getDriverClass());
        return new HikariDataSource(hikariConfig);
    }
}
