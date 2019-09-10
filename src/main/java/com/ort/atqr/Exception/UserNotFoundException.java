package com.ort.atqr.Exception;

public class UserNotFoundException extends Exception {
    @Override
    public String getMessage() {
        return "The User wasn't found";
    }
}
