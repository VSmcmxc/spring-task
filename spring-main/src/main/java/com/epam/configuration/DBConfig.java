package com.epam.configuration;

import javax.sql.DataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;


@Configuration
@ComponentScan("com.epam")
public class DBConfig {

  @Bean
  public DataSource hsqlDataSource() {
    return new EmbeddedDatabaseBuilder()
        .setType(EmbeddedDatabaseType.H2)
        .setScriptEncoding("UTF-8")
        .addScript("classpath:create_tables.sql")
        .build();
  }

  @Bean
  public JdbcTemplate hsqlTemplate() {
    return new JdbcTemplate(hsqlDataSource());
  }


}
