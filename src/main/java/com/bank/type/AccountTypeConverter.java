package com.bank.type;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;
import java.util.Arrays;

/**
 * @author mco on 23/2/19
 */
@Converter
public class AccountTypeConverter implements AttributeConverter<AccountType, String> {

    @Override
    public String convertToDatabaseColumn(AccountType accountType) {
        return accountType.getCode();
    }

    @Override
    public AccountType convertToEntityAttribute(String code) {
        return Arrays.stream(AccountType.values())
                        .filter(type -> type.getCode().equals(code))
                        .findFirst()
                        .orElseThrow(() ->
                                new IllegalStateException(String.format("Unsupported account type %s.", code)));
    }

}
