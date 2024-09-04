package ru.liquibaseDocker.liquibase.exception;

public class InvalidOperationTypeException extends RuntimeException{
    public InvalidOperationTypeException(final String message) {
        super(message);
    }
}
