package ru.liquibaseDocker.liquibase.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.liquibaseDocker.liquibase.dto.WalletDto;
import ru.liquibaseDocker.liquibase.dto.WalletOperationRequest;
import ru.liquibaseDocker.liquibase.model.Wallet;
import ru.liquibaseDocker.liquibase.service.WalletService;


import java.util.UUID;

@RestController
@RequestMapping("/api/v1")
@RequiredArgsConstructor
public class Controller {

    @Autowired
    private WalletService walletService;


    @PostMapping("/wallet")
    public WalletDto depositOperation(@Valid @RequestBody WalletOperationRequest operation) {
        return walletService.depositOperation(operation);
    }

    @GetMapping("/wallets/{WALLET_UUID}")
    public ResponseEntity<Object> getWalletBalance(@PathVariable UUID WALLET_UUID) {
            return ResponseEntity.ok(walletService.getWalletBalance(WALLET_UUID));
    }
}
