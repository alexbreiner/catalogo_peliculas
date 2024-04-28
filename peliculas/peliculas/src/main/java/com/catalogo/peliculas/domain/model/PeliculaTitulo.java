package com.catalogo.peliculas.domain.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.Validate;

@Getter
public class PeliculaTitulo {

    private final String value;
    @JsonCreator
    public PeliculaTitulo(@JsonProperty("value") String value) {
        Validate.notNull(value,"El título no puede estar nulo");
        Validate.isTrue(value.trim().length() <= 100, "El título debe tener una longitud máxima de 100 caracteres");
        Validate.isTrue(StringUtils.isNoneBlank(value), "El título no puede estar en blanco");
        this.value = value;
    }
}
