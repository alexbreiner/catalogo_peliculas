package com.catalogo.peliculas.domain.model;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class PeliculaId {
    private final Integer value;

    public PeliculaId(Integer value) {
        this.value = value;
    }
}
