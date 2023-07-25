package com.ilgazProject.movieApp.dao;


import com.ilgazProject.movieApp.entity.Movie;

import java.util.List;

public interface MovieDao {
    //crud
    void save(Movie movie);//create
    Movie findById(Integer id);//read

    List<Movie> findByRating(Double rating);
    List<Movie> findByDirector(String directorName);
    void ratingUpdate(Integer id , Double newRating);//update
    void directorNameUpdate(String newName);
    void removeById(Integer id);//delete
    void removeByDirector(String directorName);//delete



}
