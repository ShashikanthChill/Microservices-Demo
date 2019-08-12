package com.thehumblefool.moviecatalogdemo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.client.RestTemplate;

@RestController
public class MainController {

    @Autowired
    RestTemplate restTemplate;
    
    @Autowired
    RatingsAndMovieService rams;

    @RequestMapping(path = "/postnewcatalogitem", method = RequestMethod.POST)
    public int createNewMovieCatalogItemHandler(@Valid @RequestBody MovieCatalogItem catalogItem) {
        MovieModel movieModel = new MovieModel();
        movieModel.setName(catalogItem.getMovieName());
        movieModel.setDescription(catalogItem.getMovieDescription());
        Integer movieId = restTemplate.postForObject("http://MOVIE-INFO-DEMO-EUREKA-CLIENT/postmovie", movieModel, Integer.class);
        RatingModel ratingModel = new RatingModel(catalogItem.getUserId(), movieId, catalogItem.getMovieRating());
        Integer ratingId = restTemplate.postForObject("http://RATING-INFO-DEMO-EUREKA-CLIENT/postrating", ratingModel, Integer.class);
        return ratingId;
    }

    @RequestMapping(path = "/catalogitem/{id}", method = RequestMethod.GET)
    public List<MovieCatalogItem> createNewMovieCatalogItemHandler(@PathVariable(value = "id") int id) {
        List<RatingModel> ratingModels = rams.getRatings(id);
        List<MovieModel> movieModels = rams.getMovies(ratingModels, id);
        List<MovieCatalogItem> movieCatalogItems = new ArrayList<>();
        for (int i = 0; i < ratingModels.size(); i++) {
            movieCatalogItems.add(new MovieCatalogItem(id, movieModels.get(i).getId(), movieModels.get(i).getName(), movieModels.get(i).getDescription(), ratingModels.get(i).getRating()));
        }
        return movieCatalogItems;
    }
    
    private List<MovieCatalogItem> fallbackMethod(int id) {
        return Arrays.asList(new MovieCatalogItem(id, -1, "null", "null", 0.0));
    }
}
