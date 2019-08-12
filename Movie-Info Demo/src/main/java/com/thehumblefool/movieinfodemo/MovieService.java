package com.thehumblefool.movieinfodemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class MovieService {

    @Autowired
    MoviesRepo moviesRepo;

    public List<MovieDTO> loadAllMovies() {
        List<Movie> movies = moviesRepo.findAll();
        List<MovieDTO> movieDTOs = movies.stream().map((t) -> {
            return new MovieDTO(t.getId(), t.getName(), t.getDescription());
        }).collect(Collectors.toList());
        return movieDTOs;
    }

    public MovieDTO loadMovieById(int id) {
        Movie movie = moviesRepo.findById(id).get();
        return new MovieDTO(movie.getId(),movie.getName(),movie.getDescription());
    }

    public int saveNewMovie(MovieDTO movieDTO) {
        Movie movie = new Movie();
        movie.setName(movieDTO.getName());
        movie.setDescription(movieDTO.getDescription());
        movie = moviesRepo.saveAndFlush(movie);
        return movie.getId();
    }

}
