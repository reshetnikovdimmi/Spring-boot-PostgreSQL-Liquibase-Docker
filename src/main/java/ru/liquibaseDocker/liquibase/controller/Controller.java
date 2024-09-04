package ru.liquibaseDocker.liquibase.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.liquibaseDocker.liquibase.model.WalletOperationRequest;
import ru.liquibaseDocker.liquibase.service.WalletService;


import java.util.UUID;

@RestController
@RequestMapping("/api/v1")
@RequiredArgsConstructor
public class Controller {

    @Autowired
    private WalletService walletService;


    @PostMapping("/wallet")
    public ResponseEntity<String> depositOperation(@Valid @RequestBody WalletOperationRequest operation) {
        walletService.depositOperation(operation);
        return ResponseEntity.ok("Выполнение операции успешно завершено!");
    }

    @GetMapping("/wallets/{WALLET_UUID}")
    public ResponseEntity<Object> getWalletBalance(@PathVariable("WALLET_UUID") String WALLET_UUID) {
        return ResponseEntity.ok(walletService.getWalletBalance(UUID.fromString(WALLET_UUID)));
    }


    @RequestMapping("/")
    public String getRedirectUrl() {
        return "redirect:swagger-ui/";
    }

}
