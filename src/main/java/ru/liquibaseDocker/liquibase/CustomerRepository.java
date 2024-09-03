package ru.liquibaseDocker.liquibase;


import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface CustomerRepository extends JpaRepository<Wallet, UUID> { }