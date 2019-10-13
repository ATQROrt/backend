package com.ort.atqr.Exception;

public enum ErrorMessage {
    INVALID_NAME("Name must be valid"),
    INVALID_LAST_NAME("Last name can't be null or empty"),
    INVALID_DOCUMENT("Document can't be null and must be a valid number"),
    INVALID_BIRTHDATE("Birth date can't be null and must be a valid date"),
    INVALID_MAIL("Mail can't be null"),
    INVALID_PASSWORD("Password can't be null and must be between 8 an 16 characters"),
    INVALID_CODE("Code must be valid"),
    INVALID_INFO("Information is invalid"),
    NOT_FOUND("We couldn't find what you were looking for"),
    INVALID_ASSIGNATURE("Assignature can't be null");

    private String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return this.message;
    }
}
