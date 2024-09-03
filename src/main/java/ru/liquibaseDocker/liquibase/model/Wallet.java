package ru.liquibaseDocker.liquibase.model;

import jakarta.persistence.*;
import lombok.*;
import ru.liquibaseDocker.liquibase.dto.WalletDto;

import java.math.BigDecimal;
import java.util.UUID;

import static jakarta.persistence.GenerationType.AUTO;

@Data
@Entity
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Wallet {
    @Id
    @GeneratedValue(strategy = AUTO)
    @Column(name = "wallet_id")
    private UUID walletId;
    private BigDecimal amount;
}