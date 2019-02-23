package com.bank.repository;

import com.bank.model.Account;
import com.bank.model.Transaction;
import com.bank.type.AccountType;
import com.bank.type.TransactionType;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.math.BigDecimal;
import java.util.Collection;
import java.util.Date;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

/**
 * @author mco on 23/2/19
 */
@ExtendWith(SpringExtension.class)
@Import(InitTestDatabase.class)
@DataJpaTest
public class TransactionRepositoryTest {

    @Autowired
    private TestEntityManager testEntityManager;

    @Autowired
    private TransactionRepository transactionRepository;

    @Test
    public void testGetTransactions() {
        Account account = new Account();
        account.setId(12345);
        account.setName("AUCurrent");
        account.setAccountType(AccountType.CURRENT);
        account.setCurrency("AUD");
        account.setCurrentBalance(BigDecimal.TEN);
        account.setBalanceDate(new Date());
        testEntityManager.persist(account);
        testEntityManager.flush();

        Transaction transaction = new Transaction();
        transaction.setAccount(account);
        transaction.setAmount(BigDecimal.TEN);
        transaction.setTransactionType(TransactionType.CREDIT);
        transaction.setNarrative("Initial Deposit");
        transaction.setValueDate(new Date());

        testEntityManager.merge(transaction);
        testEntityManager.flush();

        Collection<Transaction> transactions = transactionRepository.findByAccount(account);

        assertThat(transactions.size(), is(1));
        assertThat(((List<Transaction>) transactions).get(0).getAccount(), is(account));
        assertThat(((List<Transaction>) transactions).get(0).getTransactionType(),
                                                        is(transaction.getTransactionType()));

    }

}
