package nl.han.se.cnp.bewd.controller;

import jakarta.servlet.http.HttpServletRequest;
import nl.han.se.cnp.bewd.domain.Movie;
import nl.han.se.cnp.bewd.exceptions.MovieNotFoundException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
public class RestMovieNotFoundExcHandler extends MovieNotFoundException {

    @ExceptionHandler(value = {
            MovieNotFoundException.class
    })
    protected ResponseEntity<Object> handleConflict(
            MovieNotFoundException ex) {
        String message = ex.getMessage();
        return ResponseEntity.status(HttpStatus.BAD_GATEWAY).body(message);
    }

}
