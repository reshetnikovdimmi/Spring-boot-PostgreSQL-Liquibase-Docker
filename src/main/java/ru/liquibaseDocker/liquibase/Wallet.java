package ru.liquibaseDocker.liquibase;

import jakarta.persistence.*;
import lombok.*;

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
    private String amount;
}