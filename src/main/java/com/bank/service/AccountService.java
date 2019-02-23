package com.bank.service;

import com.bank.dto.AccountTransactionDTO;
import com.bank.model.Account;
import com.bank.model.Transaction;
import com.bank.repository.AccountRepository;
import com.bank.repository.TransactionRepository;
import com.bank.type.TransactionType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Comparator;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * Service component to retrieve account related information.
 *
 * @author mco on 23/2/19
 */
@Service
public class AccountService {

    private static final Logger log = LoggerFactory.getLogger(AccountService.class);

    @Autowired
    private AccountRepository accountRepository;

    @Autowired
    private TransactionRepository transactionRepository;

    private Function<Transaction, AccountTransactionDTO> convertToAccountTransaction
       = (transaction -> {
           log.debug("Converting {}", transaction);
            AccountTransactionDTO accountTransactionDTO = new AccountTransactionDTO();
            Account account = transaction.getAccount();
            accountTransactionDTO.setAccountName(account.getName());
            accountTransactionDTO.setAccountNumber(account.getId());
            accountTransactionDTO.setCreditDebit(transaction.getTransactionType().getDescription());
            if (TransactionType.DEBIT == transaction.getTransactionType()) {
                accountTransactionDTO.setDebitAmount(transaction.getAmount());
                accountTransactionDTO.setCreditAmount(BigDecimal.ZERO);
            } else {
                accountTransactionDTO.setDebitAmount(BigDecimal.ZERO);
                accountTransactionDTO.setCreditAmount(transaction.getAmount());
            }
            accountTransactionDTO.setCurrency(account.getCurrency());
            accountTransactionDTO.setValueDate(transaction.getValueDate());
            accountTransactionDTO.setTransactionNarrative(transaction.getNarrative());
            return accountTransactionDTO;
    });


    public List<Account> getAccounts() {
        log.info("Retrieving accounts...");
        return accountRepository.findAll();
    }

    public List<AccountTransactionDTO> getTransactions(long accountNo) {
        Account account = new Account();
        account.setId(accountNo);
        List<Transaction> transactions = transactionRepository.findByAccount(account);
        return transactions.stream()
                .sorted(Comparator.comparing(Transaction::getValueDate).reversed())
                .map(convertToAccountTransaction)
                .peek(accountTransactionDTO
                      -> log.debug("Account transaction successfully converted {}", accountTransactionDTO))
                .collect(Collectors.toList());
    }


}
