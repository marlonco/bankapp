package com.bank.configuration;

import liquibase.integration.spring.SpringLiquibase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import javax.sql.DataSource;

/**
 * Initialises the sample database to be used for this application.
 *
 * @author mco on 23/2/19
 */
@Configuration
@Profile("!test")
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
