package ru.liquibaseDocker.liquibase.service;




import ru.liquibaseDocker.liquibase.model.WalletOperationRequest;

import java.util.UUID;

public interface WalletService {



    Object getWalletBalance(UUID walletUuid);

    void depositOperation(WalletOperationRequest operation);
}
