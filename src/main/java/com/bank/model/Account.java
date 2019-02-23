package com.bank.model;

import com.bank.type.AccountType;
import com.bank.type.AccountTypeConverter;
import com.fasterxml.jackson.annotation.JsonIgnore;

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
import java.util.Objects;
import java.util.StringJoiner;

/**
 * The domain object model to represent account.
 *
 * @author mco on 23/2/19
 */
@Entity
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
    private Collection transactions;

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
     * Getter for property 'name'.
     *
     * @return Value for property 'name'.
     */
    public String getName() {
        return name;
    }

    /**
     * Setter for property 'name'.
     *
     * @param name Value to set for property 'name'.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Getter for property 'accountType'.
     *
     * @return Value for property 'accountType'.
     */
    public AccountType getAccountType() {
        return accountType;
    }

    /**
     * Setter for property 'accountType'.
     *
     * @param accountType Value to set for property 'accountType'.
     */
    public void setAccountType(AccountType accountType) {
        this.accountType = accountType;
    }

    /**
     * Getter for property 'currency'.
     *
     * @return Value for property 'currency'.
     */
    public String getCurrency() {
        return currency;
    }

    /**
     * Setter for property 'currency'.
     *
     * @param currency Value to set for property 'currency'.
     */
    public void setCurrency(String currency) {
        this.currency = currency;
    }

    /**
     * Getter for property 'currentBalance'.
     *
     * @return Value for property 'currentBalance'.
     */
    public BigDecimal getCurrentBalance() {
        return currentBalance;
    }

    /**
     * Setter for property 'currentBalance'.
     *
     * @param currentBalance Value to set for property 'current_balance'.
     */
    public void setCurrentBalance(BigDecimal currentBalance) {
        this.currentBalance = currentBalance;
    }

    /**
     * Getter for property 'balanceDate'.
     *
     * @return Value for property 'balanceDate'.
     */
    public Date getBalanceDate() {
        return balanceDate;
    }

    /**
     * Setter for property 'balanceDate'.
     *
     * @param balanceDate Value to set for property 'balanceDate'.
     */
    public void setBalanceDate(Date balanceDate) {
        this.balanceDate = balanceDate;
    }

    /**
     * Getter for property 'transactions'.
     *
     * @return Value for property 'transactions'.
     */
    @JsonIgnore
    public Collection getTransactions() {
        return transactions;
    }

    /**
     * Setter for property 'transactions'.
     *
     * @param transactions Value to set for property 'transactions'.
     */
    public void setTransactions(Collection transactions) {
        this.transactions = transactions;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;

        Account that = (Account) o;

        return Objects.equals(this.accountType, that.accountType) && Objects.equals(this.balanceDate, that.balanceDate)
                        && Objects.equals(this.currency, that.currency) && Objects
                        .equals(this.currentBalance, that.currentBalance) && Objects.equals(this.id, that.id)
                        && Objects.equals(this.name, that.name) && Objects.equals(this.transactions, that.transactions);
    }

    @Override
    public int hashCode() {
        return Objects.hash(accountType, balanceDate, currency, currentBalance, id, name, transactions);
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", this.getClass().getSimpleName() + "[", "]").add("accountType = " + accountType)
                        .add("balanceDate = " + balanceDate).add("currency = " + currency)
                        .add("current_balance = " + currentBalance).add("id = " + id).add("name = " + name).toString();
    }

}

