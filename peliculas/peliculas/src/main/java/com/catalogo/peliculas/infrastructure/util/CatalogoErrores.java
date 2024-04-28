package com.catalogo.peliculas.infrastructure.util;

public enum CatalogoErrores {

    MOVIES_NOT_FOUND("ERR_MOVIES_001", "movies not  found"),
    INVALID_MOVIES("ERR_MOVIES_002", "Invalid movies parameters"),
    GENERIC_ERROR("ERR_GENERIC_001", "A unexpected error ocurred");

    private final String code;
    private final String message;

    CatalogoErrores(String code, String message) {
        this.code = code;
        this.message = message;
    }

    public String getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}
