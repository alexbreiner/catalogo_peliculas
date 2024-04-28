package com.catalogo.peliculas.domain.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.Validate;

@Getter
public class CategoriaNombre {
    private final String value;

    @JsonCreator
    public CategoriaNombre(@JsonProperty("value") String value) {
        Validate.notNull(value, "El nombre no puede estar nulo");
        Validate.isTrue(StringUtils.isNoneBlank(value), "El nombre no puede estar en blanco");
        this.value = value;
    }
}
