package com.example.logistics.config;

import org.flywaydb.core.Flyway;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import javax.sql.DataSource;

@Configuration
@PropertySource("classpath:application.properties")
public class FlywayConfig {

    @Value("${spring.flyway.url}")
    private String dbUrl;

    @Value("${spring.flyway.user}")
    private String dbUser;

    @Value("${spring.flyway.password}")
    private String dbPassword;

    @Bean
    public Flyway flyway(DataSource dataSource){
        Flyway flyway = Flyway.configure().dataSource(dataSource).baselineOnMigrate(true).locations("classpath:db/migration").load();
        flyway.migrate();
        return  flyway;
    }
}
