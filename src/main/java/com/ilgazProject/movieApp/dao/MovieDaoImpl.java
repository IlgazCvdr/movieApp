package com.ilgazProject.movieApp.dao;

import com.ilgazProject.movieApp.entity.Movie;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.Predicate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Objects;

@Repository
public class MovieDaoImpl implements MovieDao{
    //define field for entity manager
    private final EntityManager entityManager;
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

    //@Override
    //public List<Movie> findByRating(Double rating) {
    //
    //    Predicate predicate =
    //    entityManager.createQuery("from Movie", Movie.class);
    //    //from movie buradaki movie class namei butun jpa ler entitylere bakiyor sql de yazana degil
    //    return
    //}

    @Override
    public List<Movie> findByDirector(String directorName) {
        TypedQuery<Movie> query= entityManager.createQuery("From Movie WHERE  directorName =:theData", Movie.class);//todo burada baska nasil ayirabilecegine bak
        query.setParameter("theData", directorName);
        return query.getResultList();
    }

    @Override
    public void ratingUpdate(Integer id, Double newRating) {
        Movie tempMovie = entityManager.find(Movie.class, id);
        tempMovie.setRating(newRating);
        entityManager.merge(tempMovie);//updates the entity
    }

    @Override
    public void directorNameUpdate(Integer id, String newName) {
        Query query = entityManager.createQuery("update Movie Set directorName = :theData");
        query.setParameter("theData", newName);
        query.executeUpdate();
        //todo bunu farkli yaptin calisma durumuna bak
    }

    @Override
    public void remove(Integer id) {

    }
    //implement student dao


}
