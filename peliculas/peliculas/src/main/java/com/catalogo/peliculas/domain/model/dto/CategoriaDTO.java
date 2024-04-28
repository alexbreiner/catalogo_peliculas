package com.catalogo.peliculas.domain.model.dto;

import com.catalogo.peliculas.domain.model.CategoriaId;
import com.catalogo.peliculas.domain.model.CategoriaNombre;
import lombok.Builder;
import lombok.Getter;

@Builder
public class CategoriaDTO {
    private CategoriaId id;
    private CategoriaNombre nombre;

    public CategoriaDTO(CategoriaId id, CategoriaNombre nombre) {
        this.id = id;
        this.nombre = nombre;
    }
}
