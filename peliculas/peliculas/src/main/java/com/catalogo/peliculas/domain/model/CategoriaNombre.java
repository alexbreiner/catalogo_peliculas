package com.catalogo.peliculas.domain.model;

import lombok.Getter;

@Getter
public class CategoriaNombre {
    private final String value;

    public CategoriaNombre(String value) {
        this.value = value;
    }
}
