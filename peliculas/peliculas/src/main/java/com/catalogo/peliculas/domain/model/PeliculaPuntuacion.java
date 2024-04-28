package com.catalogo.peliculas.domain.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.Validate;

@Getter
public class PeliculaPuntuacion {
    private final Integer value;

    @JsonCreator
    public PeliculaPuntuacion(@JsonProperty("value") Integer value) {
        Validate.notNull(value,"La puntuación no puede estar nula");
        Validate.isTrue(value <= 5, "La puntuación o calificacion es de 0 a 5.");
        Validate.isTrue(StringUtils.isNoneBlank(value.toString()), "El puntuación no puede estar en blanco");
        this.value = value;
    }
}
