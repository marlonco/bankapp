package com.bank.repository;

import com.bank.model.Account;
import com.bank.type.AccountType;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.context.annotation.Import;
import org.springframework.core.env.Environment;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.math.BigDecimal;
import java.util.Collection;
import java.util.Date;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.hasItemInArray;
import static org.hamcrest.Matchers.is;

/**
 * @author mco on 23/2/19
 */
@ExtendWith(SpringExtension.class)
@Import(InitTestDatabase.class)
@ActiveProfiles("test")
@DataJpaTest
public class AccountRepositoryTest {

    @Autowired
    private TestEntityManager testEntityManager;

    @Autowired
    private AccountRepository accountRepository;

    @Autowired
    private Environment environment;

    @Test
    public void testFindAll() {
        assertThat(environment.getActiveProfiles(), hasItemInArray("test"));

        Account account = new Account();
        account.setId(12345);
        account.setName("AUCurrent");
        account.setAccountType(AccountType.CURRENT);
        account.setCurrency("AUD");
        account.setCurrentBalance(BigDecimal.TEN);
        account.setBalanceDate(new Date());

        testEntityManager.persist(account);
        testEntityManager.flush();

        Collection<Account> accounts = accountRepository.findAll();

        assertThat(accounts.size(), is(1));
        assertThat(((List<Account>) accounts).get(0).getId(), is(account.getId()));
    }

}
