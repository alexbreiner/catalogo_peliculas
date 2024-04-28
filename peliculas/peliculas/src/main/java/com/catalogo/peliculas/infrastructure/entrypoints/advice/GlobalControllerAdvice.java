package com.catalogo.peliculas.infrastructure.entrypoints.advice;

import com.catalogo.peliculas.domain.model.ErrorResponse;
import com.catalogo.peliculas.domain.model.exception.PeliculaNotFoundException;
import com.catalogo.peliculas.infrastructure.util.CatalogoErrores;
import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;
import java.util.Collections;
import java.util.stream.Collectors;

@RestControllerAdvice
public class GlobalControllerAdvice {

    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(PeliculaNotFoundException.class)
    public ErrorResponse handleMoviesNotFoundException() {
        return ErrorResponse.builder()
                .code(CatalogoErrores.MOVIES_NOT_FOUND.getCode())
                .message(CatalogoErrores.MOVIES_NOT_FOUND.getMessage())
                .timeStand(LocalDateTime.now())
                .build();
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ErrorResponse handleMethodArgumentNotValidException(MethodArgumentNotValidException exception) {
        BindingResult result = exception.getBindingResult();

        return ErrorResponse.builder()
                .code(CatalogoErrores.INVALID_MOVIES.getCode())
                .message(CatalogoErrores.INVALID_MOVIES.getMessage())
                .details(result.getFieldErrors()
                        .stream()
                        .map(DefaultMessageSourceResolvable::getDefaultMessage)
                        .collect(Collectors.toList()))
                .timeStand(LocalDateTime.now())
                .build();
    }

    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(Exception.class)
    public ErrorResponse handleGenericError(Exception exception) {
        return ErrorResponse.builder()
                .code(CatalogoErrores.GENERIC_ERROR.getCode())
                .message(CatalogoErrores.GENERIC_ERROR.getMessage())
                .details(Collections.singletonList(exception.getMessage()))
                .timeStand(LocalDateTime.now())
                .build();
    }
}
