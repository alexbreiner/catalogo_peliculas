package com.catalogo.peliculas.domain.gateways;

import com.catalogo.peliculas.domain.model.Peliculas;
import org.springframework.data.domain.Page;

import java.util.List;

public interface ObtenerPeliculas {

     Page<Peliculas> obtenerListaPeliculas(Integer pageSize, Integer pageNumber, String sort, String dir);

     Peliculas guardarPeliculas(Peliculas peliculas);

     Peliculas obtenerDetalle(Integer id);

     List<Peliculas> obtenerPeliculasPorCategoriaYPuntuacionYduracion(Integer categoriaId, Integer puntuacion, Integer duracion);
}
