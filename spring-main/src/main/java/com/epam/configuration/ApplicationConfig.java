package com.epam.configuration;


import com.com.RoleChecker;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;

import javax.sql.DataSource;

@Configuration
@EnableAspectJAutoProxy
@ComponentScan("com.epam")
public class ApplicationConfig {

    @Bean(name = "roleChecker")
    public RoleChecker getRoleChecker() {
        return new RoleChecker();
    }

    @Bean
    public DataSource hsqlDataSource() {
        return new EmbeddedDatabaseBuilder()
                .setType(EmbeddedDatabaseType.H2)
                .setScriptEncoding("UTF-8")
                .addScript("create_tables.sql")
                .build();
    }

    @Bean
    public JdbcTemplate hsqlTemplate() {
        return new JdbcTemplate(hsqlDataSource());
    }

   /* @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.any())
                .paths(PathSelectors.any())
                .build();
    }*/

}
