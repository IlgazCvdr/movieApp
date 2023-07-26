package com.ilgazProject.movieApp.dao;


import com.ilgazProject.movieApp.entity.Movie;

import java.util.List;

public interface MovieDao {
    //crud
    void save(Movie movie);//create
    Movie findById(Movie movie);//read
    List<Movie> findByRating(Movie movie);
    List<Movie> findByDirector(Movie movie);
    void ratingUpdate(Movie movie);//update
    void removeById(Movie movie);//delete
    void removeByDirector(Movie movie);//delete



}
