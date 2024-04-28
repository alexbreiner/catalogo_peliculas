package com.catalogo.peliculas.infrastructure.entrypoints.rest;

import com.catalogo.peliculas.domain.model.ApiResponse;
import com.catalogo.peliculas.domain.model.dto.PeliculaDTO;
import com.catalogo.peliculas.domain.model.exception.PeliculaNotFoundException;
import com.catalogo.peliculas.domain.usecase.PeliculasCasoUso;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping(value = "/api", produces = MediaType.APPLICATION_JSON_VALUE)
public class PeliculaRestController {

    public static final String RESPUESTA_OF_SEVER_OK = "Respuesta ok";
    public static final String PELICULA_NO_ENCONTRADA = "Pelicula no encontrada";
    public static final String ERROR_EN_LA_SOLICITUD = "Error en la solicitud";

    private final PeliculasCasoUso casoUso;

    public PeliculaRestController(PeliculasCasoUso casoUso) {
        this.casoUso = casoUso;
    }

    @PostMapping("/pelicula")
    public ResponseEntity<ApiResponse> guardarPelicula(@RequestBody PeliculaDTO peliculaDTO) {
        try {
            PeliculaDTO data = casoUso.guardarPelicula(peliculaDTO);
            ApiResponse response = new ApiResponse(data, HttpStatus.CREATED.value(), RESPUESTA_OF_SEVER_OK);
            return new ResponseEntity<>(response, HttpStatus.CREATED);
        } catch (PeliculaNotFoundException e) {
            ApiResponse response = new ApiResponse(null, HttpStatus.BAD_REQUEST.value(), ERROR_EN_LA_SOLICITUD);
            return new ResponseEntity<ApiResponse>(response, HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/peliculas")
    public ResponseEntity<ApiResponse> obtenerPeliculas(@RequestParam(value = "pageSize") Integer pageSize,
                                                        @RequestParam(value = "pageNumber") Integer pageNumber,
                                                        @RequestParam(value = "sort.dir", required = false) String dir,
                                                        @RequestParam(value = "sort", required = false) String sort) {

        Page<PeliculaDTO> peliculasPage = casoUso.obtenerListaPeliculas(pageSize, pageNumber, sort, dir);
        ApiResponse response = new ApiResponse(
                peliculasPage,
                HttpStatus.OK.value(),
                RESPUESTA_OF_SEVER_OK
        );
        return ResponseEntity.ok(response);
    }

    @GetMapping("/pelicula/{id}")
    public ResponseEntity<ApiResponse> obtenerDetalle(@PathVariable("id") Integer id) {
        try {
            PeliculaDTO data = casoUso.obtenerDetalle(id);
            ApiResponse apiResponse = new ApiResponse(data, HttpStatus.OK.value(), RESPUESTA_OF_SEVER_OK);
            return ResponseEntity.ok(apiResponse);
        } catch (PeliculaNotFoundException e) {
            ApiResponse response = new ApiResponse(null, HttpStatus.NOT_FOUND.value(), PELICULA_NO_ENCONTRADA);
            return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/pelicula/filtrar")
    public ResponseEntity<ApiResponse> filtrarPeliculasPorCategoriaPoPuntuacionYduracion(@RequestParam Integer categoriaId,
                                                                                         @RequestParam Integer puntuacion,
                                                                                         @RequestParam Integer duracion) {
        try {
            List<PeliculaDTO> data  = casoUso.obtenerPeliculasPorCategoriaYPuntuacionYduracion(categoriaId, puntuacion, duracion);
            ApiResponse apiResponse = new ApiResponse(data, HttpStatus.OK.value(), RESPUESTA_OF_SEVER_OK);
            return ResponseEntity.ok(apiResponse);
        } catch (PeliculaNotFoundException e) {
            ApiResponse response = new ApiResponse(null, HttpStatus.NOT_FOUND.value(), PELICULA_NO_ENCONTRADA);
            return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
        }
    }
}
