package ru.liquibaseDocker.liquibase.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.liquibaseDocker.liquibase.dto.WalletDto;
import ru.liquibaseDocker.liquibase.dto.WalletOperationRequest;
import ru.liquibaseDocker.liquibase.exception.NotFoundException;
import ru.liquibaseDocker.liquibase.model.Wallet;
import ru.liquibaseDocker.liquibase.repository.WalletRepository;

import java.util.UUID;


@Service
public class WalletServiceImpl implements WalletService{

    @Autowired
    private WalletRepository walletRepository;

    @Override
    public WalletDto depositOperation(WalletOperationRequest operation) {
        return null;
    }

    @Override
    public Wallet getWalletBalance(UUID walletUuid) {
        return walletRepository.findByWalletId(walletUuid)
                .orElseThrow(() -> new NotFoundException("Кошелек не найден"));
    }


}
