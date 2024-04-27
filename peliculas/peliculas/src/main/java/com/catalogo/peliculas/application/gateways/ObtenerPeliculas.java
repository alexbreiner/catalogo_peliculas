package com.catalogo.peliculas.application.gateways;

import com.catalogo.peliculas.domain.model.Peliculas;
import com.catalogo.peliculas.infraestructure.persistence.entity.PeliculaEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ObtenerPeliculas {

    public Page<Peliculas> obtenerListaPeliculas(Pageable pageable);

    public Peliculas guardarPeliculas(Peliculas peliculas);

    public Peliculas obtenerDetalle(Integer id);

}
