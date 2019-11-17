package com.ort.atqr.Model;

import com.ort.atqr.Exception.ErrorMessage;
import com.ort.atqr.Exception.InvalidInputException;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Asignature implements Validatable {
    @Id
    @Column(unique = true)
    private String code;
    private String name;

    public Asignature() { }

    public Asignature(String code, String name) {
        this.code = code;
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

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
