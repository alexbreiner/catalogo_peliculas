package com.catalogo.peliculas.domain.model;

import lombok.Getter;

@Getter
public class PeliculaTitulo {
    private final String value;

    public PeliculaTitulo(String value) {
        this.value = value;
    }
}
