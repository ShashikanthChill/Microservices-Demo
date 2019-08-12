package com.thehumblefool.movieinfodemo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MoviesRepo extends JpaRepository<Movie,Integer>
{
}
