package com.bank.dto;

import java.math.BigDecimal;
import java.util.Date;
import java.util.Objects;
import java.util.StringJoiner;

/**
 * Contains all the transaction information for a given account to be returned to the invoker.
 * Value are mapped from {@link com.bank.model.Account} and {@link com.bank.model.Transaction}
 *
 * @author mco on 23/2/19
 */
public class AccountTransactionDTO {

    private long accountNumber;

    private String accountName;

    private Date valueDate;

    private String currency;

    private BigDecimal debitAmount;

    private BigDecimal creditAmount;

    private String creditDebit;

    private String transactionNarrative;

    /**
     * Getter for property 'accountNumber'.
     *
     * @return Value for property 'accountNumber'.
     */
    public long getAccountNumber() {
        return accountNumber;
    }

    /**
     * Setter for property 'accountNumber'.
     *
     * @param accountNumber Value to set for property 'accountNumber'.
     */
    public void setAccountNumber(long accountNumber) {
        this.accountNumber = accountNumber;
    }

    /**
     * Getter for property 'accountName'.
     *
     * @return Value for property 'accountName'.
     */
    public String getAccountName() {
        return accountName;
    }

    /**
     * Setter for property 'accountName'.
     *
     * @param accountName Value to set for property 'accountName'.
     */
    public void setAccountName(String accountName) {
        this.accountName = accountName;
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
     * Getter for property 'debitAmount'.
     *
     * @return Value for property 'debitAmount'.
     */
    public BigDecimal getDebitAmount() {
        return debitAmount;
    }

    /**
     * Setter for property 'debitAmount'.
     *
     * @param debitAmount Value to set for property 'debitAmount'.
     */
    public void setDebitAmount(BigDecimal debitAmount) {
        this.debitAmount = debitAmount;
    }

    /**
     * Getter for property 'creditAmount'.
     *
     * @return Value for property 'creditAmount'.
     */
    public BigDecimal getCreditAmount() {
        return creditAmount;
    }

    /**
     * Setter for property 'creditAmount'.
     *
     * @param creditAmount Value to set for property 'creditAmount'.
     */
    public void setCreditAmount(BigDecimal creditAmount) {
        this.creditAmount = creditAmount;
    }

    /**
     * Getter for property 'creditDebit'.
     *
     * @return Value for property 'creditDebit'.
     */
    public String getCreditDebit() {
        return creditDebit;
    }

    /**
     * Setter for property 'creditDebit'.
     *
     * @param creditDebit Value to set for property 'creditDebit'.
     */
    public void setCreditDebit(String creditDebit) {
        this.creditDebit = creditDebit;
    }

    /**
     * Getter for property 'transactionNarrative'.
     *
     * @return Value for property 'transactionNarrative'.
     */
    public String getTransactionNarrative() {
        return transactionNarrative;
    }

    /**
     * Setter for property 'transactionNarrative'.
     *
     * @param transactionNarrative Value to set for property 'transactionNarrative'.
     */
    public void setTransactionNarrative(String transactionNarrative) {
        this.transactionNarrative = transactionNarrative;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;

        AccountTransactionDTO that = (AccountTransactionDTO) o;

        return Objects.equals(this.accountName, that.accountName) && Objects
                        .equals(this.accountNumber, that.accountNumber) && Objects
                        .equals(this.creditAmount, that.creditAmount) && Objects
                        .equals(this.creditDebit, that.creditDebit) && Objects.equals(this.currency, that.currency)
                        && Objects.equals(this.debitAmount, that.debitAmount) && Objects
                        .equals(this.transactionNarrative, that.transactionNarrative) && Objects
                        .equals(this.valueDate, that.valueDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(accountName, accountNumber, creditAmount, creditDebit, currency, debitAmount,
                        transactionNarrative, valueDate);
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", this.getClass().getSimpleName() + "[", "]").add("accountName = " + accountName)
                        .add("accountNumber = " + accountNumber).add("creditAmount = " + creditAmount)
                        .add("creditDebit = " + creditDebit).add("currency = " + currency)
                        .add("debitAmount = " + debitAmount).add("transactionNarrative = " + transactionNarrative)
                        .add("valueDate = " + valueDate).toString();
    }

}
