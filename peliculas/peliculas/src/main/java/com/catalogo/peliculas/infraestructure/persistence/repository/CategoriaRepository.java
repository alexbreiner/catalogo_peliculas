package com.catalogo.peliculas.infraestructure.persistence.repository;

import com.catalogo.peliculas.domain.model.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoriaRepository extends JpaRepository<Categoria, String> {
}
