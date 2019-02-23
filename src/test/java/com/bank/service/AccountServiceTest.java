package com.bank.service;

import com.bank.dto.AccountTransactionDTO;
import com.bank.model.Account;
import com.bank.model.Transaction;
import com.bank.repository.AccountRepository;
import com.bank.repository.TransactionRepository;
import com.bank.type.TransactionType;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.mockito.Mockito.doReturn;

/**
 * @author mco on 23/2/19
 */
@ExtendWith(SpringExtension.class)
public class AccountServiceTest {

    @TestConfiguration
    static class AccountServiceContext {

        @Bean
        public AccountService accountService() {
            return new AccountService();
        }
    }

    @Autowired
    private AccountService accountService;

    @MockBean
    private AccountRepository accountRepository;

    @MockBean
    private TransactionRepository transactionRepository;

    @Test
    public void testGetAccounts() {
        Account account = new Account();
        account.setId(12345);

        doReturn(Arrays.asList(account)).when(accountRepository).findAll();

        Collection<Account> accounts = accountService.getAccounts();

        assertThat(accounts.size(), is(1));
        assertThat(((List<Account>) accounts).get(0).getId(), is(account.getId()));
    }

    @Test
    public void testGetTransactions() {
        long accountNo = 12345;
        Account account = new Account();
        account.setId(accountNo);
        Transaction transaction = new Transaction();
        transaction.setAccount(account);
        transaction.setTransactionType(TransactionType.CREDIT);
        transaction.setAmount(BigDecimal.TEN);

        doReturn(Arrays.asList(transaction)).when(transactionRepository).findByAccount(account);

        Collection<AccountTransactionDTO> accountTransactionDTOs = accountService.getTransactions(12345);

        assertThat(accountTransactionDTOs.size(), is(1));
        assertThat(((List<AccountTransactionDTO>) accountTransactionDTOs).get(0).getAccountNumber(), is(accountNo));
        assertThat(((List<AccountTransactionDTO>) accountTransactionDTOs).get(0).getCreditAmount(),
                                                                        is(transaction.getAmount()));

    }


}
