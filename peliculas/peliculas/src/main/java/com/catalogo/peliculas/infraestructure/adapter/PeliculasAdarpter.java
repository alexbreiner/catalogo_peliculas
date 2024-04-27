package com.catalogo.peliculas.infraestructure.adapter;

import com.catalogo.peliculas.infraestructure.persistence.entity.PeliculaEntity;
import com.catalogo.peliculas.infraestructure.persistence.repository.PeliculaRepository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class PeliculasAdarpter {
    private final PeliculaRepository peliculaRepository;

    public PeliculasAdarpter(PeliculaRepository peliculaRepository) {
        this.peliculaRepository = peliculaRepository;
    }

    public PeliculaEntity guardar(PeliculaEntity peliculas) {
        return peliculaRepository.save(peliculas);
    }

    public Page<PeliculaEntity> obtenerPeliculas(Pageable pageable) {
        return peliculaRepository.findAll(pageable);

    }
    public PeliculaEntity obtenerDettalle(Integer id) {
        return peliculaRepository.findById(id).get();
    }

}
