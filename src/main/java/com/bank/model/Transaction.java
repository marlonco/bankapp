package com.bank.model;

import com.bank.type.TransactionType;
import com.bank.type.TransactionTypeConverter;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.Date;

/**
 * The domain object model for transaction.
 *
 * @author mco on 23/2/19
 */
@Entity
@ToString
@EqualsAndHashCode
@Getter
@Setter
public class Transaction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    @NotNull
    private long id;

    @Column(name="value_date")
    @Temporal(TemporalType.TIMESTAMP)
    @NotNull
    private Date valueDate;

    @Column(name="credit")
    @Convert(converter = TransactionTypeConverter.class)
    @NotNull
    private TransactionType transactionType;

    @Column(name="amount")
    @NotNull
    private BigDecimal amount;

    @Column(name="narrative")
    @NotNull
    private String narrative;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "account_no", referencedColumnName = "id")
    @JsonManagedReference
    private Account account;

}
