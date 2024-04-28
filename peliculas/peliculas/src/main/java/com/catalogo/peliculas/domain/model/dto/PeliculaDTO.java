package com.catalogo.peliculas.domain.model.dto;

import com.catalogo.peliculas.domain.model.*;
import lombok.Builder;

import java.util.List;
import java.util.stream.Collectors;

@Builder
public class PeliculaDTO {
    private PeliculaId id;
    private PeliculaTitulo titulo;
    private PeliculaDescripcion descripcion;
    private PeliculaDuracion duracion;
    private PeliculaPuntuacion puntuacion;
    private Categoria categoriaId;

    public PeliculaDTO() {}

    public Peliculas toDomain() {
        return new Peliculas(id, titulo, descripcion, duracion, puntuacion, categoriaId);
    }

    public static PeliculaDTO fromDomain(Peliculas peliculas) {
        return new PeliculaDTO(peliculas.getId(),
                                peliculas.getTitulo(),
                                peliculas.getDescripcion(),
                                peliculas.getDuracion(),
                                peliculas.getPuntuacion(),
                                peliculas.getCategoriaId());
    }

    public static List<PeliculaDTO> fromDomainList(List<Peliculas> peliculas) {
        return peliculas.stream()
                .map(PeliculaDTO::fromDomain)
                .collect(Collectors.toList());
    }


    public PeliculaDTO(PeliculaId id, PeliculaTitulo titulo, PeliculaDescripcion descripcion, PeliculaDuracion duracion, PeliculaPuntuacion puntuacion, Categoria categoriaId) {
        this.id = id;
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.duracion = duracion;
        this.puntuacion = puntuacion;
        this.categoriaId = categoriaId;
    }

    public PeliculaId getId() {
        return id;
    }

    public void setId(PeliculaId id) {
        this.id = id;
    }

    public PeliculaTitulo getTitulo() {
        return titulo;
    }

    public void setTitulo(PeliculaTitulo titulo) {
        this.titulo = titulo;
    }

    public PeliculaDescripcion getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(PeliculaDescripcion descripcion) {
        this.descripcion = descripcion;
    }

    public PeliculaDuracion getDuracion() {
        return duracion;
    }

    public void setDuracion(PeliculaDuracion duracion) {
        this.duracion = duracion;
    }

    public PeliculaPuntuacion getPuntuacion() {
        return puntuacion;
    }

    public void setPuntuacion(PeliculaPuntuacion puntuacion) {
        this.puntuacion = puntuacion;
    }

    public Categoria getCategoriaId() {
        return categoriaId;
    }

    public void setCategoriaId(Categoria categoriaId) {
        this.categoriaId = categoriaId;
    }
}
