package com.bank.type;

/**
 * @author mco on 23/2/19
 */
public enum TransactionType {

    CREDIT(true, "Credit"),
    DEBIT(false, "Debit");

    private boolean credit;

    private String description;

    TransactionType(boolean credit, String description) {
        this.credit = credit;
        this.description = description;
    }

    /**
     * Getter for property 'credit'.
     *
     * @return Value for property 'credit'.
     */
    public boolean isCredit() {
        return credit;
    }

    /**
     * Getter for property 'description'.
     *
     * @return Value for property 'description'.
     */
    public String getDescription() {
        return description;
    }

}
