package com.catalogo.peliculas.infrastructure.configuracionDB;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class DbSecret {
    private final String url;
    private final String username;
    private final String password;
    private final String driverClass;
}
