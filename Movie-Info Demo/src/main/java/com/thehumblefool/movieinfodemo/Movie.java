package com.thehumblefool.movieinfodemo;

import lombok.Data;

import javax.persistence.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "movies")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Movie
{
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @Column(name = "movie_name")
    private String name;
    @Column(name = "movie_description")
    private String description;
}
