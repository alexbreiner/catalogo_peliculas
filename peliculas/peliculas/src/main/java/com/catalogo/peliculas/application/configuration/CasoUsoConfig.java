package com.catalogo.peliculas.application.configuration;

import com.catalogo.peliculas.domain.gateways.ObtenerPeliculas;
import com.catalogo.peliculas.domain.usecase.PeliculasCasoUso;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CasoUsoConfig {

    @Bean
    public PeliculasCasoUso peliculasCasoUso(ObtenerPeliculas obtenerPeliculas) {
        return new PeliculasCasoUso(obtenerPeliculas);
    }
}
