package com.catalogo.peliculas.infrastructure.persistence.entity;

import com.catalogo.peliculas.domain.model.*;
import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.util.List;
import java.util.stream.Collectors;

@Entity
@Table(name = "pelicula")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PeliculaEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Integer id;
    private String titulo;
    private String descripcion;
    private Integer duracion;
    private Integer puntuacion;

    @ManyToOne
    @JoinColumn(name = "categoria_id", referencedColumnName = "id")
    private CategoriaEntity categoriaId;

    public static PeliculaEntity fromDomain(Peliculas peliculas) {
        CategoriaEntity categoriaEntity = new CategoriaEntity();
        categoriaEntity.setId(peliculas.getCategoriaId().getId().getValue());
        return PeliculaEntity.builder()
                .id(peliculas.getId().getValue())
                .titulo(peliculas.getTitulo().getValue())
                .descripcion(peliculas.getDescripcion().toString())
                .duracion(peliculas.getDuracion().getValue())
                .puntuacion(peliculas.getPuntuacion().getValue())
                .categoriaId(categoriaEntity)
                .build();
    }

    public static Peliculas toDomain(PeliculaEntity peliculaEntity) {
        PeliculaId peliculaId = new PeliculaId(peliculaEntity.getId());
        PeliculaTitulo peliculaTitulo = new PeliculaTitulo(peliculaEntity.getTitulo().toString());
        PeliculaDescripcion peliculaDescripcion = new PeliculaDescripcion(peliculaEntity.getDescripcion().toString());
        PeliculaDuracion peliculaDuracion = new PeliculaDuracion(peliculaEntity.getDuracion());
        PeliculaPuntuacion peliculaPuntuacion = new PeliculaPuntuacion(peliculaEntity.getPuntuacion());

        Categoria categoria = new Categoria(
                new CategoriaId(peliculaEntity.getCategoriaId().getId()),
                new CategoriaNombre(peliculaEntity.getCategoriaId().getNombre())
        );

        return new Peliculas(
                peliculaId,
                peliculaTitulo,
                peliculaDescripcion,
                peliculaDuracion,
                peliculaPuntuacion,
                categoria
        );
    }

    public static List<Peliculas> toDomainList(List<PeliculaEntity> peliculaEntities) {
        return peliculaEntities.stream().map(PeliculaEntity::toDomain)
                .collect(Collectors.toList());
    }

}
