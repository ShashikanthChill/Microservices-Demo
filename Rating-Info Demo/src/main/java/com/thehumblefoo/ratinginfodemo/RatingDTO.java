/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.thehumblefoo.ratinginfodemo;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotNull;

/**
 * @author shash
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
class RatingDTO {

    @JsonProperty(value = "user-id")
    @NotNull
    private Integer userId;

    @NotNull
    @JsonProperty(value = "movie-id")
    private Integer movieId;

    @JsonProperty(value = "rating")
    @NotNull
    @DecimalMin(value = "1.0")
    @DecimalMax(value = "5.0")
    private double rating;
}
