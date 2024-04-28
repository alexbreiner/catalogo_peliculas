package com.catalogo.peliculas.domain.model;


import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.Validate;

@Getter
public class PeliculaDuracion {
    private final Integer value;

    @JsonCreator
    public PeliculaDuracion(@JsonProperty("value") Integer value) {
        Validate.notNull(value,"la duración no puede estar nulo");
        Validate.isTrue(StringUtils.isNoneBlank(value.toString()), "La duración no puede estar en blanco");
        this.value = value;
    }
}
