package ru.liquibaseDocker.liquibase.controller;

import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.liquibaseDocker.liquibase.model.WalletOperationRequest;
import ru.liquibaseDocker.liquibase.service.WalletService;


@RestController
@RequestMapping("/api/v1")
@RequiredArgsConstructor
public class Controller {


    private final WalletService walletService;

    @Tag(name="Controller изменения счета в базе данных", description="Выполняет операцию над кошельком.")

    @PostMapping("/wallet")
    public ResponseEntity<String> depositOperation(@Valid @RequestBody WalletOperationRequest operation) {
        walletService.depositOperation(operation);
        return ResponseEntity.ok("Выполнение операции успешно завершено!");
    }

    @Tag(name="Controller получения баланса кошелька", description="Возвращает баланс указанного кошелька.")

    @GetMapping("/wallets/{WALLET_UUID}")
    public ResponseEntity<Object> getWalletBalance(@PathVariable("WALLET_UUID") String WALLET_UUID) {
        return ResponseEntity.ok(walletService.getWalletBalance(WALLET_UUID));
    }



}
