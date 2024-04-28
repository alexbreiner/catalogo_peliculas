package com.catalogo.peliculas.infrastructure.entrypoints.rest;

import com.catalogo.peliculas.domain.model.*;
import com.catalogo.peliculas.domain.model.dto.CategoriaDTO;
import com.catalogo.peliculas.domain.model.dto.PeliculaDTO;
import com.catalogo.peliculas.domain.usecase.PeliculasCasoUso;
import com.catalogo.peliculas.infrastructure.persistence.entity.CategoriaEntity;
import com.catalogo.peliculas.infrastructure.persistence.entity.PeliculaEntity;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.Objects;

import static org.mockito.Mockito.when;
import static org.mockito.ArgumentMatchers.any;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.junit.jupiter.api.Assertions.*;

@WebMvcTest(PeliculaRestController.class)
class PeliculaRestControllerTest {

    @MockBean
    private PeliculasCasoUso peliculasCasoUso;

    @Autowired
    private MockMvc mockMvc;

    @BeforeEach
    void setUp() {
    }

    @Test
    @DisplayName("deberia_registrar_nueva_pelicula")
    void obtenerPeliculas() throws Exception {

        Categoria categoria = Categoria.builder()
                .id(new CategoriaId(1))
                .nombre(new CategoriaNombre("Accion"))
                .build();

        PeliculaId peliculaId = PeliculaId.builder()
                .value(1)
                .build();

        PeliculaDTO peliculaDTO = PeliculaDTO.builder()
                .id(new PeliculaId(peliculaId.getValue()))
                .titulo(new PeliculaTitulo("Spider Man"))
                .descripcion(new PeliculaDescripcion("Pelicula"))
                .duracion(new PeliculaDuracion(2))
                .puntuacion(new PeliculaPuntuacion(3))
                .categoriaId(categoria)
                .build();

        when(peliculasCasoUso.guardarPelicula(any(PeliculaDTO.class))).thenReturn(peliculaDTO);
        ObjectMapper objectMapper = new ObjectMapper();

        mockMvc.perform(post("/api/pelicula")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(peliculaDTO)))
                .andDo(print())
                .andExpect(status().isCreated())
                .andExpect(content().json(objectMapper.writeValueAsString(peliculaDTO)));
    }
}