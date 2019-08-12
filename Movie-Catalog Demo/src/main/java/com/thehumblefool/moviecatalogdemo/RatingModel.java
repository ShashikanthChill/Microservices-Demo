/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.thehumblefool.moviecatalogdemo;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author shash
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
class RatingModel {

    @JsonProperty(value = "user-id")
    private Integer userId;

    @JsonProperty(value = "movie-id")
    private Integer movieId;

    @JsonProperty(value = "rating")
    private double rating;
}
