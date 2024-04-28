package com.catalogo.peliculas.domain.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class Categoria {
    private final CategoriaId id;
    private final CategoriaNombre nombre;

    @JsonCreator
    public Categoria(@JsonProperty("id") CategoriaId id,
                     @JsonProperty("nombre") CategoriaNombre nombre) {
        this.id = id;
        this.nombre = nombre;
    }
}
