package com.bank.model;

import com.bank.type.TransactionType;
import com.bank.type.TransactionTypeConverter;

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
import java.util.Objects;
import java.util.StringJoiner;

/**
 * The domain object model for transaction.
 *
 * @author mco on 23/2/19
 */
@Entity
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
    private Account account;

    /**
     * Getter for property 'id'.
     *
     * @return Value for property 'id'.
     */
    public long getId() {
        return id;
    }

    /**
     * Setter for property 'id'.
     *
     * @param id Value to set for property 'id'.
     */
    public void setId(long id) {
        this.id = id;
    }

    /**
     * Getter for property 'valueDate'.
     *
     * @return Value for property 'valueDate'.
     */
    public Date getValueDate() {
        return valueDate;
    }

    /**
     * Setter for property 'valueDate'.
     *
     * @param valueDate Value to set for property 'valueDate'.
     */
    public void setValueDate(Date valueDate) {
        this.valueDate = valueDate;
    }

    /**
     * Getter for property 'transactionType'.
     *
     * @return Value for property 'transactionType'.
     */
    public TransactionType getTransactionType() {
        return transactionType;
    }

    /**
     * Setter for property 'transactionType'.
     *
     * @param transactionType Value to set for property 'transactionType'.
     */
    public void setTransactionType(TransactionType transactionType) {
        this.transactionType = transactionType;
    }

    /**
     * Getter for property 'amount'.
     *
     * @return Value for property 'amount'.
     */
    public BigDecimal getAmount() {
        return amount;
    }

    /**
     * Setter for property 'amount'.
     *
     * @param amount Value to set for property 'amount'.
     */
    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    /**
     * Getter for property 'narrative'.
     *
     * @return Value for property 'narrative'.
     */
    public String getNarrative() {
        return narrative;
    }

    /**
     * Setter for property 'narrative'.
     *
     * @param narrative Value to set for property 'narrative'.
     */
    public void setNarrative(String narrative) {
        this.narrative = narrative;
    }

    /**
     * Getter for property 'account'.
     *
     * @return Value for property 'account'.
     */
    public Account getAccount() {
        return account;
    }

    /**
     * Setter for property 'account'.
     *
     * @param account Value to set for property 'account'.
     */
    public void setAccount(Account account) {
        this.account = account;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;

        Transaction that = (Transaction) o;

        return Objects.equals(this.account, that.account) && Objects.equals(this.amount, that.amount) && Objects
                        .equals(this.id, that.id) && Objects.equals(this.narrative, that.narrative) && Objects
                        .equals(this.transactionType, that.transactionType) && Objects
                        .equals(this.valueDate, that.valueDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(account, amount, id, narrative, transactionType, valueDate);
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", this.getClass().getSimpleName() + "[", "]").add("account = " + account)
                        .add("amount = " + amount).add("id = " + id).add("narrative = " + narrative)
                        .add("transactionType = " + transactionType).add("valueDate = " + valueDate).toString();
    }

}
