package com.ilgazProject.movieApp.dao;

import com.ilgazProject.movieApp.entity.Movie;
import jakarta.persistence.EntityManager;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Objects;

@Repository
public class MovieDaoImpl implements MovieDao{
    //define field for entity manager
    private EntityManager entityManager;
    //injecting entity manager with constructor injection

    public MovieDaoImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    //implement save method

    @Override
    @Transactional //we are performing updates so we add transactional
    public void save(Movie movie) {
        //saves the movie to the database
        if(!Objects.equals(movie.getMovieName(),null)){
            entityManager.persist(movie);
        }
    }

    @Override
    public Movie findById(Integer id) {
        return entityManager.find(Movie.class, id);
    }

    @Override
    public void update(Integer id, Movie movie) {

    }

    @Override
    public void remove(Integer id) {

    }
    //implement student dao


}
