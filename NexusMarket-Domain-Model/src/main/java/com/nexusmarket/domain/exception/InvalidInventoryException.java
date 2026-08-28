package com.nexusmarket.domain.exception;

public class InvalidInventoryException extends RuntimeException {
    public InvalidInventoryException(String message) {
        super(message);
    }
}
