package com.ort.atqr.Exception;

public enum ErrorMessage {
    INVALID_NAME("El nombre debe ser valido"),
    INVALID_LAST_NAME("El apellido no puede ser nulo o vacio"),
    INVALID_DOCUMENT("El documento no puede ser nulo y debe ser un numero valido"),
    INVALID_BIRTHDATE("La fecha de nacimiento no puede ser nula y debe ser una fecha valida"),
    INVALID_MAIL("El mail no puede ser nulo"),
    INVALID_PASSWORD("La contrasena no debe ser nula y debe tener entre 8 y 16 caracteres"),
    INVALID_CODE("El codigo debe ser valido"),
    INVALID_INFO("La informacion es invalida"),
    NOT_FOUND("No pudimos encontrar lo que estas buscando"),
    INVALID_ASSIGNATURE("La materia no puede ser nula");

    private String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return this.message;
    }
}
