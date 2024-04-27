package com.catalogo.peliculas.domain.model;

import lombok.Getter;

@Getter
public class Categoria {
    private final String id;
    private final CategoriaNombre nombre;

    public Categoria(String id, CategoriaNombre nombre) {
        this.id = id;
        this.nombre = nombre;
    }
}
