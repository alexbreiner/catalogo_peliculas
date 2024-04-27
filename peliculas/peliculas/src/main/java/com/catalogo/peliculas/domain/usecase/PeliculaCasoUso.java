package com.catalogo.peliculas.domain.usecase;


import com.catalogo.peliculas.application.gateways.ObtenerPeliculas;
import com.catalogo.peliculas.domain.model.Peliculas;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


public class  PeliculaCasoUso {
    private final ObtenerPeliculas obtenerPeliculas;

    public PeliculaCasoUso(ObtenerPeliculas obtenerPeliculas) {
        this.obtenerPeliculas = obtenerPeliculas;
    }

    Page<Peliculas> obtenerListaPelicuas(Pageable pageable) {
        return obtenerPeliculas.obtenerListaPeliculas(pageable);
    }

    Peliculas guardarPelicula(Peliculas peliculas) {
        return obtenerPeliculas.guardarPeliculas(peliculas);
    }

    Peliculas obtenerDetalle(Integer id) {
        return obtenerPeliculas.obtenerDetalle(id);
    }
}
