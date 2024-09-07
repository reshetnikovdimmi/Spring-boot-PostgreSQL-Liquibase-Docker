package ru.liquibaseDocker.liquibase.controller;


import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import ru.liquibaseDocker.liquibase.model.OperationType;
import ru.liquibaseDocker.liquibase.model.Wallet;
import ru.liquibaseDocker.liquibase.model.WalletOperationRequest;
import ru.liquibaseDocker.liquibase.service.WalletService;

import java.math.BigDecimal;
import java.util.UUID;

import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;


@WebMvcTest(Controller.class)
class ControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private WalletService walletService;

    @Autowired
    private ObjectMapper objectMapper;

    private Wallet wallet;

    @BeforeEach
    public void setUp() {
        wallet = new Wallet();
        wallet.setWalletId(UUID.fromString("3fa85f64-5717-4562-b3fc-2c963f66afa6"));
        wallet.setAmount(BigDecimal.ZERO);
    }

    @Test
    void depositOperation() throws Exception {
        WalletOperationRequest request = new WalletOperationRequest();
        request.setWalletId(wallet.getWalletId());
        request.setOperationType(OperationType.DEPOSIT);
        request.setAmount(BigDecimal.valueOf(100));

        mockMvc.perform(post("/api/v1/wallet")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(request)))
                .andExpect(status().isOk())
                .andExpect(content().string("Выполнение операции успешно завершено!"));
    }


    @Test
    void getBalance() throws Exception {
        when(walletService.getWalletBalance(anyString())).thenReturn(wallet);

        mockMvc.perform(get("/api/v1/wallets/{WALLET_ID}", wallet.getWalletId().toString()))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.walletId").value(wallet.getWalletId().toString()))
                .andExpect(jsonPath("$.amount").value(wallet.getAmount().intValue()));
    }
}