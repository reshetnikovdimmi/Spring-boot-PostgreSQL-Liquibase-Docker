package ru.liquibaseDocker.liquibase.model;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import lombok.*;
import java.math.BigDecimal;
import java.util.UUID;
import static jakarta.persistence.GenerationType.AUTO;

/**
 * Класс продукции со свойствами <b>walletId</b> и <b>amount</b>.
 * @autor Дмитрий
 * @version 2.1
 */

@Data
@Entity
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Schema(description = "Сущность Wallet")
public class Wallet {
    @Id
    @GeneratedValue(strategy = AUTO)
    @Column(name = "wallet_id")
    @Schema(description = "Идентификатор кошелька")
    private UUID walletId;
    @Schema(description = "Баланс")
    private BigDecimal amount;


}