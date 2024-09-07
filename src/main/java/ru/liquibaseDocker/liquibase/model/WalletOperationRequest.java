package ru.liquibaseDocker.liquibase.model;

import io.swagger.v3.oas.annotations.media.Schema;
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
@Schema(description = "Сущность WalletOperation")
public class WalletOperationRequest {

    @NotNull(message = "Wallet ID не может быть null")
    @Schema(description = "Идентификатор кошелька")
    private UUID walletId;

    @NotNull(message = "Operation type не может быть null")
    @Schema(description = "Тип операции")
    private OperationType operationType;

    @Min(value = 0, message = "Amount должно быть больше или равно 0")
    @Schema(description = "Сумма операции")
    private BigDecimal amount;
}