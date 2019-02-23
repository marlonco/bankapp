package com.bank.controller;

import com.bank.dto.AccountTransactionDTO;
import com.bank.model.Account;
import com.bank.service.AccountService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

/**
 * Main entry point for account related calls.
 *
 * @author mco on 23/2/19
 */
@RestController
public class AccountController {

    private static final Logger log = LoggerFactory.getLogger(AccountController.class);

    @Autowired
    private AccountService accountService;

    /**
     * API Entry point to retrieve the collection of available accounts.
     *
     * @return list of all available accounts
     */
    @GetMapping("/accounts")
    public Collection<Account> getAccounts() {
        log.info("Retrieving account...");
        return accountService.getAccounts();
    }

    /**
     * API Entry point to retrieve the list of transactions for a given account.
     *
     * @param id the account id of which transactions are to retrieved
     * @return list of transactions for the given account id.
     */
    @GetMapping("/account/{id}")
    public Collection<AccountTransactionDTO> getTransactions(@PathVariable long id) {
        log.info("Retrieving transactions for {}", id);
        return accountService.getTransactions(id);
    }

}
