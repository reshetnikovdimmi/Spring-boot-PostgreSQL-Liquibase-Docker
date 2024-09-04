package ru.liquibaseDocker.liquibase.model;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.UUID;

@Getter
@Setter
@RequiredArgsConstructor
public class WalletOperationRequest {

    @NotNull(message = "Wallet ID не может быть null")
    private UUID walletId;

    @NotNull(message = "Operation type не может быть null")
    private OperationType operationType;

    @Min(value = 0, message = "Amount должно быть больше или равно 0")
    private BigDecimal amount;
}