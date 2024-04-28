package com.catalogo.peliculas.domain.usecase;

import com.catalogo.peliculas.domain.gateways.ObtenerPeliculas;
import com.catalogo.peliculas.domain.model.Peliculas;
import com.catalogo.peliculas.domain.model.dto.PeliculaDTO;
import com.catalogo.peliculas.domain.model.exception.PeliculaNotFoundException;
import org.springframework.data.domain.Page;

import java.util.List;
import java.util.Objects;

public class PeliculasCasoUso {

    private final ObtenerPeliculas obtenerPeliculas;

    public PeliculasCasoUso(ObtenerPeliculas obtenerPeliculas) {
        this.obtenerPeliculas = obtenerPeliculas;
    }

    public Page<PeliculaDTO> obtenerListaPeliculas(Integer pageSize,
                                                   Integer pageNumber,
                                                   String sort,
                                                   String dir) {
        if (pageNumber < 0 && pageSize < 0 && !Objects.equals(sort, "") && !Objects.equals(dir, "")) {
            throw new PeliculaNotFoundException();
        }
        Page<Peliculas>  peliculas = obtenerPeliculas.obtenerListaPeliculas(pageSize, pageNumber,sort,dir);
        return peliculas.map(PeliculaDTO::fromDomain);
    }

    public PeliculaDTO guardarPelicula(PeliculaDTO peliculaDTO) {
        return PeliculaDTO.fromDomain(obtenerPeliculas.guardarPeliculas(peliculaDTO.toDomain()));
    }

    public PeliculaDTO obtenerDetalle(Integer id) {
        return PeliculaDTO.fromDomain(obtenerPeliculas.obtenerDetalle(id));
    }

    public List<PeliculaDTO> obtenerPeliculasPorCategoriaYPuntuacionYduracion(Integer categoriaId,
                                                                              Integer puntuacion,
                                                                              Integer duracion) {
        List<Peliculas> peliculasFilter = obtenerPeliculas.obtenerPeliculasPorCategoriaYPuntuacionYduracion(categoriaId, puntuacion, duracion);
        return PeliculaDTO.fromDomainList(peliculasFilter);
    }
}
