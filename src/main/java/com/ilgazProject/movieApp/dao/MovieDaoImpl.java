package com.ilgazProject.movieApp.dao;

import com.ilgazProject.movieApp.entity.Movie;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Objects;

@Repository
@Transactional
public class MovieDaoImpl implements MovieDao {
    //define field for entity manager
    private final EntityManager entityManager;
    //injecting entity manager with constructor injection

    public MovieDaoImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    //implement save method

    @Override
    public void save(Movie movie) {
        entityManager.persist(movie);
    }

    @Override
    public Movie findById(Movie movie) {
        return entityManager.find(Movie.class, movie.getId());
    }

    @Override
    public List<Movie> findByRating(Movie movie) {

        TypedQuery<Movie> query = entityManager.createQuery("from Movie where rating >:theData", Movie.class);
        query.setParameter("theData", movie.getRating());
        //from movie buradaki movie class namei butun jpa ler entitylere bakiyor sql de yazana degil
        return query.getResultList();
    }

    @Override
    public List<Movie> findByDirector(Movie movie) {
        TypedQuery<Movie> query = entityManager.createQuery("From Movie WHERE  directorName =:theData", Movie.class);//todo burada baska nasil ayirabilecegine bak
        query.setParameter("theData", movie.getDirectorName());
        return query.getResultList();
    }

    @Override
    public void ratingUpdate(Movie movie) {
        Movie tempMovie = entityManager.find(Movie.class, movie.getId());
        tempMovie.setRating(movie.getRating());
        entityManager.merge(tempMovie);//updates the entity
    }


    @Override
    public void removeById(Movie movie) {
        Movie tempMovie = entityManager.find(Movie.class, movie.getId());
        entityManager.remove(tempMovie);
    }

    @Override
    public void removeByDirector(Movie movie) {
        Query query = entityManager.createQuery("delete from Movie where directorName =:theData");
        query.setParameter("theData", movie.getDirectorName());
        query.executeUpdate();
        //todo bunu da yine ufak farkli yaptin
    }
    //implement student dao


}
