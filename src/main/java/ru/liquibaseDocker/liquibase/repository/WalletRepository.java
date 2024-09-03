package ru.liquibaseDocker.liquibase.repository;


import jakarta.persistence.LockModeType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Lock;
import ru.liquibaseDocker.liquibase.model.Wallet;

import java.util.Optional;
import java.util.UUID;


public interface WalletRepository extends JpaRepository<Wallet, UUID> {

    @Lock(LockModeType.PESSIMISTIC_WRITE)
    Optional<Wallet> findByWalletId(UUID walletUuid);
}