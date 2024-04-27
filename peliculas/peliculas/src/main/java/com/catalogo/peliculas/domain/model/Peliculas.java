package com.catalogo.peliculas.domain.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class Peliculas {
    private final PeliculaId id;
    private final PeliculaTitulo titulo;
    private final PeliculaDescripcion descripcion;
    private final PeliculaDuracion duracion;
    private final PeliculaPuntuacion puntuacion;
    private Categoria categoriaId;
}
