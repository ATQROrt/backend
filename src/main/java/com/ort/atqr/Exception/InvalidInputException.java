package com.ort.atqr.Exception;

public class InvalidInputException extends Exception {
    public InvalidInputException(ErrorMessage errorMessage) {
        super(errorMessage.getMessage());
    }
}
