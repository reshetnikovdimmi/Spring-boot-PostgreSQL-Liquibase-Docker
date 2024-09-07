package ru.liquibaseDocker.liquibase.model;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "Сущность тип операции")
public enum OperationType {
    @Schema(description = "Пополнение")
    DEPOSIT,
    @Schema(description = "снятие")
    WITHDRAW
}
