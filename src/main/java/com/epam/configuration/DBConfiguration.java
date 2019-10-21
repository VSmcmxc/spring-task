/*
package com.epam.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;

import javax.sql.DataSource;

@Configuration
public class DBConfiguration {

    @Bean
    public DataSource hsqlDataSource() {
        return new EmbeddedDatabaseBuilder()
                .setType(EmbeddedDatabaseType.HSQL)
                .setScriptEncoding("UTF-8")
                .addScript("schema.sql")
                .addScript("hsql-data.sql")
                .build();
    }

    */
/**
     * Create jdbc template for HSQLDB.
     *
     * @return hsql database jdbc template.
     *//*

    @Bean
    public JdbcTemplate hsqlTemplate() {
        return new JdbcTemplate(hsqlDataSource());
    }
}

*/
