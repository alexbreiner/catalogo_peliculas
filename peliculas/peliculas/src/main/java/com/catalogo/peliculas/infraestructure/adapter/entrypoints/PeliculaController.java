package com.catalogo.peliculas.infraestructure.adapter.entrypoints;

import com.catalogo.peliculas.infraestructure.adapter.PeliculasAdarpter;
import com.catalogo.peliculas.infraestructure.persistence.entity.PeliculaEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/peliculas")

public class PeliculaController {

    private final PeliculasAdarpter adarpter;

    public PeliculaController(PeliculasAdarpter adarpter) {
        this.adarpter = adarpter;
    }


    @GetMapping("/all")
    public Page<PeliculaEntity> obtenerPeliculas(Pageable pageable) {
        return adarpter.obtenerPeliculas(pageable);
    }

    @GetMapping("/detalle/{id}")
    public ResponseEntity<PeliculaEntity> obtenerDetalle(@PathVariable Integer id) throws Exception{
        try{
            PeliculaEntity peliculaId = adarpter.obtenerDettalle(id);
            return ResponseEntity.ok(peliculaId);
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }
    @PostMapping("/save")
    public ResponseEntity<PeliculaEntity> guardarPelicula(@RequestBody PeliculaEntity peliculas) {
       return new ResponseEntity<>(adarpter.guardar(peliculas), HttpStatus.CREATED);
    }

}
