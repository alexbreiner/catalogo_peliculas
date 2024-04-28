package com.catalogo.peliculas.domain.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Getter;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.Validate;

@Getter
@Builder
public class PeliculaId {

    private final Integer value;

    @JsonCreator
    public PeliculaId(@JsonProperty("value") Integer value) {
        Validate.notNull(value, "El id no puede ser nulo");
        Validate.isTrue(StringUtils.isNoneBlank(value.toString()), "El id no puede estar en blanco");
        this.value = value;
    }
}
