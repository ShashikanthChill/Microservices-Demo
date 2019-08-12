/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.thehumblefool.movieinfodemo;

import com.fasterxml.jackson.annotation.JsonProperty;
import javax.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 *
 * @author shash
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class MovieDTO {

    @JsonProperty(value = "movie-id", access = JsonProperty.Access.READ_ONLY)
    private Integer id;
    @JsonProperty(value = "movie-name")
    @NotBlank
    private String name;
    @JsonProperty(value = "movie-description")
    @NotBlank
    private String description;
}
