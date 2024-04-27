package com.catalogo.peliculas.infraestructure.persistence.repository;


import com.catalogo.peliculas.infraestructure.persistence.entity.PeliculaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PeliculaRepository extends JpaRepository<PeliculaEntity, Integer> {
}
