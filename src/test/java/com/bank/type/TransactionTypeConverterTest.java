package com.bank.type;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

/**
 * @author mco on 23/2/19
 */
public class TransactionTypeConverterTest {

    private TransactionTypeConverter converter;

    @BeforeEach
    public void init() {
        converter = new TransactionTypeConverter();
    }

    @Test
    public void testConvertToDatabaseColumn() {
        assertThat(converter.convertToDatabaseColumn(TransactionType.CREDIT), is(true));
        assertThat(converter.convertToDatabaseColumn(TransactionType.DEBIT), is(false));
    }

    @Test
    public void testConvertToEntityAttribute() {
        assertThat(converter.convertToEntityAttribute(Boolean.TRUE), is(TransactionType.CREDIT));
        assertThat(converter.convertToEntityAttribute(Boolean.FALSE), is(TransactionType.DEBIT));
    }


}
