package com.thehumblefool.moviecatalogdemo;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MovieModel
{
    @JsonProperty(value = "movie-id")
    private int id;
    @JsonProperty(value = "movie-name")
    private String name;
    @JsonProperty(value = "movie-description")
    private String description;
}
