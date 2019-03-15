package com.bank.model;

import com.bank.type.AccountType;
import com.bank.type.AccountTypeConverter;
import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Data;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.Collection;
import java.util.Date;

/**
 * The domain object model to represent account.
 *
 * @author mco on 23/2/19
 */
@Entity
@Data
public class Account {

    @Id
    @Column(name="id")
    @NotNull
    private long id;

    @Column(name="name")
    @NotNull
    private String name;

    @Column(name="type")
    @Convert(converter = AccountTypeConverter.class)
    @NotNull
    private AccountType accountType;

    @Column(name="currency")
    @NotNull
    private String currency;

    @Column(name="current_balance")
    @NotNull
    private BigDecimal currentBalance;

    @Column(name="balance_date")
    @Temporal(TemporalType.TIMESTAMP)
    @NotNull
    private Date balanceDate;

    @OneToMany(mappedBy = "account", targetEntity = Transaction.class, cascade = CascadeType.ALL,
               fetch = FetchType.LAZY)
    @JsonBackReference
    private Collection transactions;

}

