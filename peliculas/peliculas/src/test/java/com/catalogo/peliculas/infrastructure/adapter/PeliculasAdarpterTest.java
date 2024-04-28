package com.catalogo.peliculas.infrastructure.adapter;

import com.catalogo.peliculas.domain.model.*;
import com.catalogo.peliculas.infrastructure.persistence.entity.PeliculaEntity;
import com.catalogo.peliculas.infrastructure.persistence.repository.PeliculaApdaterRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
@DataJpaTest
@ActiveProfiles("test")
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class PeliculasAdarpterTest {

    @Autowired
    private PeliculaApdaterRepository peliculaApdaterRepository;

    @InjectMocks
    private PeliculasAdarpter peliculasAdarpter;

    @BeforeEach
    void setUp() {
        peliculasAdarpter = new PeliculasAdarpter(peliculaApdaterRepository);
    }

    @Test
    void obtenerListaPeliculas() {
    }

    @Test
    void guardarPeliculas() {
        //Arrange
        Peliculas peliculas = new Peliculas(
                new PeliculaId(1),
                new PeliculaTitulo("Prueba"),
                new PeliculaDescripcion("Descripcion"),
                new PeliculaDuracion(1),
                new PeliculaPuntuacion(5),
                new Categoria(new CategoriaId(1), new CategoriaNombre("Prueba"))
        );
        //act
        Peliculas peliculasSaved  = peliculasAdarpter.guardarPeliculas(peliculas);
        Optional<PeliculaEntity> peliculaEntity = Optional.ofNullable(PeliculaEntity.fromDomain(
                peliculasAdarpter.obtenerDetalle(peliculasSaved.getId().getValue()))
        );
        //assert
        assertTrue(peliculaEntity.isPresent());
    }

    @Test
    void obtenerDetalle() {
    }
}