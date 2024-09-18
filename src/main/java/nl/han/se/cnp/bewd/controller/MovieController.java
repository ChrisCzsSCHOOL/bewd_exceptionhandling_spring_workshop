package nl.han.se.cnp.bewd.controller;

import nl.han.se.cnp.bewd.domain.Movie;
import nl.han.se.cnp.bewd.exceptions.MovieNotFoundException;
import nl.han.se.cnp.bewd.repository.MovieList;
import nl.han.se.cnp.bewd.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/movies")
public class MovieController {
    private final MovieService movieService;

    @Autowired
    public MovieController(MovieService movieService) {
        this.movieService = movieService;
    }

    @GetMapping
    public MovieList getAllMovies() {
        return movieService.getMovieList();
    }

    @GetMapping("/")
    public Movie getMovieById(@RequestParam("id") String id) {

        return movieService.getMovieById(id);
    }

    @GetMapping("/{id}")
    public Movie getMovieByIdInUrl(@PathVariable("id") String id) {
        return movieService.getMovieById(id);
    }
//
//    @ExceptionHandler(MovieNotFoundException.class)
//    public ResponseEntity<String> handleMovieNotFoundException(MovieNotFoundException ex) {
//        return new ResponseEntity<>("", HttpStatus.NOT_FOUND);
//    }

//    @ResponseStatus(HttpStatus.NOT_FOUND)
//    void onMovieNotFoundExc(MovieNotFoundException e) {}
}
