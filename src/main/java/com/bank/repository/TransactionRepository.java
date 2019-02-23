package com.bank.repository;

import com.bank.model.Account;
import com.bank.model.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * * Interface to interact with the backend (i.e. database) to retrieve and manipulate transaction information.
 *
 * @author mco on 23/2/19
 */
public interface TransactionRepository extends JpaRepository<Transaction, Long> {

    List<Transaction> findByAccount(Account account);

}
