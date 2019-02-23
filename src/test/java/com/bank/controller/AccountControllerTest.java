package com.bank.controller;

import com.bank.dto.AccountTransactionDTO;
import com.bank.model.Account;
import com.bank.service.AccountService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Arrays;

import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * @author mco on 23/2/19
 */
@ExtendWith(SpringExtension.class)
@WebMvcTest(value = AccountController.class, secure = false)
public class AccountControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private AccountService accountService;

    @Test
    public void testGetAccounts() throws Exception {
        Account account = new Account();
        account.setId(12345);
        account.setName("AUSavings");

        given(accountService.getAccounts()).willReturn(Arrays.asList(account));

        mockMvc.perform(get("/accounts")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(1)))
                .andExpect(jsonPath("$[0].id", is((int) account.getId())))
                .andExpect(jsonPath("$[0].name", is(account.getName())));

    }

    @Test
    public void testGetTransactions() throws Exception {
        long accountNo = 12345;

        AccountTransactionDTO accountTransactionDTO = new AccountTransactionDTO();
        accountTransactionDTO.setAccountNumber(accountNo);
        accountTransactionDTO.setCurrency("AUD");

        given(accountService.getTransactions(accountNo)).willReturn(Arrays.asList(accountTransactionDTO));

        mockMvc.perform(get("/account/" + accountNo)
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(1)))
                .andExpect(jsonPath("$[0].accountNumber", is((int) accountTransactionDTO.getAccountNumber())))
                .andExpect(jsonPath("$[0].currency", is(accountTransactionDTO.getCurrency())));
    }

}
