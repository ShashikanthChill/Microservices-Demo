package com.thehumblefoo.ratinginfodemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class RatingService {

    @Autowired
    RatingsRepo ratingsRepo;

    public List<RatingDTO> loadAllRatingsByUserId(int id) {
        List<Rating> ratings = ratingsRepo.findAllByUserId(id);
        List<RatingDTO> ratingDTOs = ratings.stream().map((Rating t) -> {
            return new RatingDTO(t.getUserId(), t.getMovieId(), t.getRating());
        }).collect(Collectors.toList());
        return ratingDTOs;
    }

    public int saveNewRating(RatingDTO ratingDTO) {
        Rating rating = new Rating();
        rating.setUserId(ratingDTO.getUserId());
        rating.setMovieId(ratingDTO.getMovieId());
        rating.setRating(ratingDTO.getRating());
        rating = ratingsRepo.saveAndFlush(rating);
        return rating.getId();
    }
}
