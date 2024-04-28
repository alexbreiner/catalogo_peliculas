package com.catalogo.peliculas.domain.model;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@Builder
public class Peliculas {
    private final PeliculaId id;
    private final PeliculaTitulo titulo;
    private final PeliculaDescripcion descripcion;
    private final PeliculaDuracion duracion;
    private final PeliculaPuntuacion puntuacion;
    private final Categoria categoriaId;
}
