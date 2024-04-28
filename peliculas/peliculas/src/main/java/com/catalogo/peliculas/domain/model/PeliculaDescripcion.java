package com.catalogo.peliculas.domain.model;


import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.Validate;

@Getter
public class PeliculaDescripcion {

    private final String value;
    @JsonCreator
    public PeliculaDescripcion(@JsonProperty("value") String value) {
        Validate.notNull(value, "la descripción no puede estar nula");
        Validate.isTrue(StringUtils.isNoneBlank(value), "La descripción no puede estar en blanco");
        Validate.isTrue(value.trim().length() <= 200, "La descripción debe tenern maximo 200 caracteres");
        this.value = value;
    }
    @Override
    public String toString() {
        return this.value;
    }
}
