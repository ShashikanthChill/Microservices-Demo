package com.thehumblefoo.ratinginfodemo;

import lombok.Data;

import javax.persistence.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "ratings")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Rating {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @Column(name = "user_id")
    private int userId;
    @Column(name = "movie_id")
    private int movieId;
    @Column(name = "rating")
    private double rating;
}
