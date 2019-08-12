package com.thehumblefool.moviecatalogdemo;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MovieCatalogItem {

    @JsonProperty(value = "user-id")
    @NotNull
    private Integer userId;
    
    @JsonProperty(value = "movie-id",access = JsonProperty.Access.READ_ONLY)
    private Integer movieId;
    
    @JsonProperty(value = "movie-name")
    @NotBlank
    private String movieName;
    
    @JsonProperty(value = "movie-description")
    @NotBlank
    private String movieDescription;
    
    @JsonProperty(value = "movie-rating")
    @NotNull
    @DecimalMin(value = "1.0")
    @DecimalMax(value = "5.0")
    private double movieRating;

}
