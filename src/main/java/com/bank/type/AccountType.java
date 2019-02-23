package com.bank.type;

/**
 * @author mco on 23/2/19
 */
public enum AccountType {

    CURRENT("C", "Current"),
    SAVINGS("S", "Savings");

    private String code;

    private String description;

    AccountType(String code, String description) {
        this.code = code;
        this.description = description;
    }

    /**
     * Getter for property 'code'.
     *
     * @return Value for property 'code'.
     */
    public String getCode() {
        return code;
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
