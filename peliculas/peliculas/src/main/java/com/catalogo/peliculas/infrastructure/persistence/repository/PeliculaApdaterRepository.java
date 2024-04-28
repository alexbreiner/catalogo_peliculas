package com.catalogo.peliculas.infrastructure.persistence.repository;

import com.catalogo.peliculas.infrastructure.persistence.entity.PeliculaEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PeliculaApdaterRepository extends JpaRepository<PeliculaEntity, Integer> {
    List<PeliculaEntity> findByCategoriaId_IdAndPuntuacionAndDuracion(Integer categoriaId, Integer puntuacion, Integer duracion);
}
