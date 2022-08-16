package epita.controller;

import epita.datamodel.Movie;
import epita.exceptions.BadRequestAlertException;
import epita.exceptions.ResourceNotFoundException;
import epita.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

@RestController
@RequestMapping("/api")
public class MovieController {

    @Autowired
    private MovieRepository movieRepository;

    @PostMapping("/movies")
    public ResponseEntity<Movie> createMovie(@RequestBody Movie movie) throws URISyntaxException {
        if (movie.getId() != null) {
            throw new BadRequestAlertException("ID Exisits");
        }
        Movie result = movieRepository.createMovie(movie);
        return ResponseEntity.created(new URI("/api/movies/" + result.getId()))
                .body(result);
    }

    @GetMapping("/movies")
    public List<Movie> getAllMovies() {
        return movieRepository.getMovies();
    }

    @GetMapping("/get-movie/{category}")
    public List<Movie> getMoviesCatergory(@PathVariable String category) {
        return movieRepository.getByCategory(category);
    }

    @GetMapping("/movies/{id}")
    public ResponseEntity<Movie> getMovie(@PathVariable Long id) {
        Movie movie = movieRepository.getById(id);
        if(!movie.getId().equals(id)){
            throw new ResourceNotFoundException("Not found movie with id = " + id);
        }
        return new ResponseEntity<>(movie, HttpStatus.OK);
    }

    @DeleteMapping("/movies/{id}")
    public ResponseEntity<Void> deleteMovie(@PathVariable Long id) {
        Movie movie = movieRepository.getById(id);
        if(!movie.getId().equals(id)){
            throw new ResourceNotFoundException("Not found Role with id = " + id);
        }
        else{
            movieRepository.deleteByName(movie.getTitle());
        }
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }


}
