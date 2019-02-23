package com.bank.type;

import javax.persistence.AttributeConverter;

/**
 * @author mco on 23/2/19
 */
public class TransactionTypeConverter implements AttributeConverter<TransactionType, Boolean> {

    @Override
    public Boolean convertToDatabaseColumn(TransactionType transactionType) {
        return transactionType.isCredit();
    }

    @Override
    public TransactionType convertToEntityAttribute(Boolean credit) {
        return credit ? TransactionType.CREDIT : TransactionType.DEBIT;
    }

}
