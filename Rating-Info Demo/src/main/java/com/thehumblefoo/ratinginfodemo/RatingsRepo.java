package com.thehumblefoo.ratinginfodemo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface RatingsRepo extends JpaRepository<Rating,Integer>
{
    public List<Rating> findAllByUserId(int userId);
}
