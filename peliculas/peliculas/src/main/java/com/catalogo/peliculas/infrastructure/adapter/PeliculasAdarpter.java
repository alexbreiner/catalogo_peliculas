package com.catalogo.peliculas.infrastructure.adapter;

import com.catalogo.peliculas.domain.gateways.ObtenerPeliculas;
import com.catalogo.peliculas.domain.model.Peliculas;
import com.catalogo.peliculas.domain.model.exception.PeliculaNotFoundException;
import com.catalogo.peliculas.infrastructure.persistence.entity.PeliculaEntity;
import com.catalogo.peliculas.infrastructure.persistence.repository.PeliculaApdaterRepository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class PeliculasAdarpter implements ObtenerPeliculas {

    private final PeliculaApdaterRepository peliculaApdaterRepository;

    public PeliculasAdarpter(PeliculaApdaterRepository peliculaApdaterRepository) {
        this.peliculaApdaterRepository = peliculaApdaterRepository;
    }

    @Override
    public Page<Peliculas> obtenerListaPeliculas(Integer pageSize, Integer pageNumber, String sort, String dir) {
        Pageable pageable;
        if (sort != null) {
            pageable = PageRequest.of(pageNumber, pageSize, Sort.by(Sort.Direction.valueOf(dir.toUpperCase()), sort));
        } else {
            pageable = PageRequest.of(pageNumber, pageSize, Sort.by(Sort.Direction.ASC, "id"));
        }
        return peliculaApdaterRepository.findAll(pageable)
                .map(PeliculaEntity::toDomain);
    }

    @Override
    public Peliculas guardarPeliculas(Peliculas peliculas) {
        PeliculaEntity peliculaEntity = PeliculaEntity.fromDomain(peliculas);
        return PeliculaEntity.toDomain(peliculaApdaterRepository.save(peliculaEntity));
    }

    @Override
    public Peliculas obtenerDetalle(Integer id) {
        return peliculaApdaterRepository.findById(id)
                .map(PeliculaEntity::toDomain)
                .orElseThrow(PeliculaNotFoundException::new);
    }

    @Override
    public List<Peliculas> obtenerPeliculasPorCategoriaYPuntuacionYduracion(Integer categoria, Integer puntuacion, Integer duracion) {
        return PeliculaEntity.toDomainList(
                peliculaApdaterRepository.findByCategoriaId_IdAndPuntuacionAndDuracion(categoria, puntuacion, duracion)
        );
    }
}
