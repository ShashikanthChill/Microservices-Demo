package com.thehumblefoo.ratinginfodemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;
import org.springframework.web.bind.annotation.RequestMethod;

@RestController
public class MainController {

    @Autowired
    RatingService ratingService;

    @RequestMapping(path = "/ratings/{user_id}")
    public List<RatingDTO> allRatingsByUserIdHandler(@PathVariable(value = "user_id") int userId) {
        return ratingService.loadAllRatingsByUserId(userId);
    }

    @RequestMapping(path = "/postrating", method = RequestMethod.POST)
    public int postNewRatingHandler(@Valid @RequestBody RatingDTO ratingDTO) {
//        System.out.println("Got rating: " + ratingDTO);
//        if (ratingDTO != null)
//        {
//            return new ResponseEntity<>(HttpStatus.OK);
//        }
//        else
//            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        return ratingService.saveNewRating(ratingDTO);
    }
}
