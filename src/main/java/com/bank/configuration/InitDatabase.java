package com.bank.configuration;

import liquibase.integration.spring.SpringLiquibase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

/**
 * Initialises the sample database to be used for this application.
 *
 * @author mco on 23/2/19
 */
@Configuration
public class InitDatabase {

    @Autowired
    private DataSource dataSource;

    @Bean
    public SpringLiquibase liquibase() {
        final SpringLiquibase liquibase = new SpringLiquibase();
        liquibase.setChangeLog("classpath:db/account/changelog.xml");
        liquibase.setDataSource(dataSource);
        return liquibase;
    }

}
