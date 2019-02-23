package com.bank.type;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.junit.jupiter.api.Assertions.assertThrows;

/**
 * @author mco on 23/2/19
 */
public class AccountTypeConverterTest {

    private AccountTypeConverter converter;

    @BeforeEach
    public void init() {
        converter = new AccountTypeConverter();
    }

    @Test
    public void testConvertToDatabaseColumn() {
        assertThat(converter.convertToDatabaseColumn(AccountType.CURRENT), is(AccountType.CURRENT.getCode()));
        assertThat(converter.convertToDatabaseColumn(AccountType.SAVINGS), is(AccountType.SAVINGS.getCode()));
    }

    @Test
    public void testConvertToEntityAttribute() {
        assertThat(converter.convertToEntityAttribute(AccountType.CURRENT.getCode()), is(AccountType.CURRENT));
        assertThat(converter.convertToEntityAttribute(AccountType.SAVINGS.getCode()), is(AccountType.SAVINGS));
    }

    @Test
    public void testConvertToEntityAttributesForInvalidCode() {
        assertThrows(IllegalStateException.class, () -> converter.convertToEntityAttribute("INVALIDCODE"));
    }

}
