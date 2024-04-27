package com.catalogo.peliculas.infraestructure.persistence.entity;

import com.catalogo.peliculas.domain.model.*;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "pelicula")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PeliculaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Integer id;
    private String titulo;
    private String descripcion;
    private Integer duracion;
    private Integer puntuacion;

    @ManyToOne
    private Categoria categoriaId;
}
