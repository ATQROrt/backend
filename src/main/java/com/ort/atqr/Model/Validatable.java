package com.ort.atqr.Model;

import com.ort.atqr.Exception.InvalidInputException;

public interface Validatable {
    void validate() throws InvalidInputException;
}
