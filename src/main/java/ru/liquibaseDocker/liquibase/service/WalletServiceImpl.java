package ru.liquibaseDocker.liquibase.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.liquibaseDocker.liquibase.exception.InsufficientFundsException;
import ru.liquibaseDocker.liquibase.exception.InvalidOperationTypeException;
import ru.liquibaseDocker.liquibase.exception.NotFoundException;
import ru.liquibaseDocker.liquibase.model.OperationType;
import ru.liquibaseDocker.liquibase.model.Wallet;
import ru.liquibaseDocker.liquibase.model.WalletOperationRequest;
import ru.liquibaseDocker.liquibase.repository.WalletRepository;
import java.math.BigDecimal;
import java.util.UUID;


@Service
public class WalletServiceImpl implements WalletService {

    @Autowired
    private WalletRepository walletRepository;

    @Override
    public void depositOperation(WalletOperationRequest operation) {
        Wallet wallet = walletRepository.findByWalletId(operation.getWalletId())
                .orElseThrow(() -> new NotFoundException("Кошелек не найден"));

        if (operation.getOperationType().equals(OperationType.DEPOSIT)) {
            deposit(wallet, operation.getAmount());
        } else if (operation.getOperationType().equals(OperationType.WITHDRAW)) {
            withdraw(wallet, operation.getAmount());
        } else
            throw new InvalidOperationTypeException("Неверный тип операции");

        walletRepository.save(wallet);

    }


    private void deposit(Wallet wallet, BigDecimal amount) {
        wallet.setAmount(wallet.getAmount().add(amount));
    }

    private void withdraw(Wallet wallet, BigDecimal amount) {
        if (wallet.getAmount().compareTo(amount) < 0) {
            throw new InsufficientFundsException("Недостаточно средств на кошельке");
        }
        wallet.setAmount(wallet.getAmount().subtract(amount));
    }


    @Override
    public Wallet getWalletBalance(UUID walletUuid) {
        return walletRepository.findByWalletId(walletUuid)
                .orElseThrow(() -> new NotFoundException("Кошелек не найден"));

    }


}
