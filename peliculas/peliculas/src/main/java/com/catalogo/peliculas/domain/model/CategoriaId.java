package com.catalogo.peliculas.domain.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.Validate;

@Getter
public class CategoriaId {
    private final Integer value;
    @JsonCreator
    public CategoriaId(@JsonProperty("value") Integer value) {
        Validate.notNull(value,"id no puede estar nulo");
        Validate.isTrue(StringUtils.isNoneBlank(value.toString()), "El id no puede estar en blanco");
        this.value = value;
    }
}
