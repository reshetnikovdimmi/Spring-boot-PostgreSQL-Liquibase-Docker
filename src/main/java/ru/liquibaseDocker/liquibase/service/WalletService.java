package ru.liquibaseDocker.liquibase.service;

import ru.liquibaseDocker.liquibase.dto.WalletDto;
import ru.liquibaseDocker.liquibase.dto.WalletOperationRequest;

import java.util.UUID;

public interface WalletService {

    WalletDto depositOperation(WalletOperationRequest operation);

    Object getWalletBalance(UUID walletUuid);

}
