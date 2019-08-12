/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.thehumblefool.moviecatalogdemo;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

/**
 *
 * @author shash
 */
@Service
public class RatingsAndMovieService {

    @Autowired
    RestTemplate restTemplate;

    @HystrixCommand(fallbackMethod = "getFallbackRatings")
    public List<RatingModel> getRatings(int id) throws RestClientException {
        List<RatingModel> ratingModels = Arrays.asList(restTemplate.getForObject("http://RATING-INFO-DEMO-EUREKA-CLIENT/ratings/" + id, RatingModel[].class));
        return ratingModels;
    }

    @HystrixCommand(fallbackMethod = "getFallbackMovies")
    public List<MovieModel> getMovies(List<RatingModel> ratingModels, int id) {
        List<MovieModel> movieCatalogItems = ratingModels.stream().map((RatingModel t) -> {
            return restTemplate.getForObject("http://MOVIE-INFO-DEMO-EUREKA-CLIENT/movie/" + t.getMovieId(), MovieModel.class);
        }).collect(Collectors.toList());
        return movieCatalogItems;
    }

    public List<RatingModel> getFallbackRatings(int id) {
        return Arrays.asList(new RatingModel(id, -1, 0.0));
    }

    public List<MovieModel> getFallbackMovies(List<RatingModel> ratingModels, int id) {
//        return Arrays.asList(new MovieModel(ratingModels.get(0).getMovieId(), "fallback_movie_title", "fallback_movie_description"));
        return ratingModels.stream().map((t) -> {
            return new MovieModel(t.getMovieId(), "fallback_movie_title", "fallback_movie_description");
        }).collect(Collectors.toList());
    }
}
