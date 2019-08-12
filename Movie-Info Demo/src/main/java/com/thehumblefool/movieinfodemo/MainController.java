package com.thehumblefool.movieinfodemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class MainController {

    @Autowired
    MovieService movieService;

    @RequestMapping(path = "/movie/all")
    public List<MovieDTO> getAllMoviesHandler() {
        return movieService.loadAllMovies();
    }

    @RequestMapping(path = "/movie/{id}")
    public MovieDTO getMovieByIdHandler(@PathVariable(value = "id") int id) {
        return movieService.loadMovieById(id);
    }

    @RequestMapping(path = "/postmovie", method = RequestMethod.POST)
    public int postNewMovieHandler(@Valid @RequestBody MovieDTO movieDTO) {
//        System.out.println("Movie DTO: " + movieDTO);
//        if (movieDTO != null) {
//            return 200;
//        } else {
//            return 400;
//        }
        return movieService.saveNewMovie(movieDTO);
    }
}
