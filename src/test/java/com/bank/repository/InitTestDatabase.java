package com.bank.repository;

import liquibase.integration.spring.SpringLiquibase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import javax.sql.DataSource;

/**
 * Use to initialise the database to be exclusively used for testing.
 *
 * @author mco on 23/2/19
 */
@Configuration
@Profile("test")
public class InitTestDatabase {

    @Autowired
    private DataSource dataSource;

    /**
     * Only creates the database schema.
     *
     * @return the liquibase configuration for unit testing
     */
    @Bean
    public SpringLiquibase liquibase() {
        final SpringLiquibase liquibase = new SpringLiquibase();
        liquibase.setChangeLog("classpath:db/account/changelog-for-unit-test.xml");
        liquibase.setDataSource(dataSource);
        return liquibase;
    }

}
