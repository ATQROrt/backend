package com.ort.atqr.Model;

import com.ort.atqr.Exception.ErrorMessage;
import com.ort.atqr.Exception.InvalidInputException;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Asignature implements Validatable {
    @Id
    private String code;
    private String name;

    @Override
    public void validate() throws InvalidInputException {
        if (code == null || code.isEmpty()) {
            throw new InvalidInputException(ErrorMessage.INVALID_CODE);
        }

        if (name == null || name.isEmpty()) {
            throw new InvalidInputException(ErrorMessage.INVALID_NAME);
        }
    }
}
