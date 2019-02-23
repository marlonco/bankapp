package com.bank.repository;

import com.bank.model.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Interface to interact with the backend (i.e. database) to retrieve and manipulate account information.
 *
 * @author mco on 23/2/19
 */
@Repository
public interface AccountRepository extends JpaRepository<Account, Long> {

}
