package ru.liquibaseDocker.liquibase.repository;



import org.springframework.data.jpa.repository.JpaRepository;
import ru.liquibaseDocker.liquibase.model.Wallet;

import java.util.Optional;
import java.util.UUID;


public interface WalletRepository extends JpaRepository<Wallet, UUID> {


    Optional<Wallet> findByWalletId(UUID walletUuid);
}