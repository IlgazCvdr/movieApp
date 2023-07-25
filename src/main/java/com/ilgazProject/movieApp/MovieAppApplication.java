package com.ilgazProject.movieApp;

import com.ilgazProject.movieApp.dao.MovieDao;
import com.ilgazProject.movieApp.entity.Movie;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@SpringBootApplication
public class MovieAppApplication {
    public static void main(String[] args) {
        SpringApplication.run(MovieAppApplication.class, args);
    }

    @Bean
    public CommandLineRunner commandLineRunner(String[] args, MovieDao movieDao) {
        return runner -> {
            //createMovie(movieDao, "dirName", "movName", 0);
            //findMovieById(movieDao, 0);//id ve movie data acc
            //findMovieByDirector(movieDao,"directorName")
            //findMovieByRating(movieDao, 0.0);
            updateRating(movieDao,0,0.0);
            directorNameUpdate(movieDao,"newName");
            removeById(movieDao,0);
            removeByDirector(movieDao,"directorName");
        };
    }

    public void createMovie(MovieDao movieDao, String dirName, String movieName, double rating) {
        //create a movie object
        Movie tempMovie = new Movie(dirName, movieName, rating);
        //save the movie object
        movieDao.save(tempMovie);
        System.out.println(tempMovie + " is saved");
    }

    public Movie findMovieById(MovieDao movieDao, Integer id) {
        Movie tempMovie = movieDao.findById(id);
        System.out.println("The movie id found. Its values are " + tempMovie.toString());
        return tempMovie;
    }

    public List<Movie> findMovieByDirector(MovieDao movieDao, String directorName) {
        List<Movie> tempMovieList = movieDao.findByDirector(directorName);
        for (Movie movie : tempMovieList) {
            System.out.println(movie.getMovieName() +" is directed by "+movie.getDirectorName());
        }
        return tempMovieList;
    }

    public List<Movie> findMovieByRating(MovieDao movieDao, Double rating) {
        List<Movie> tempMovieList = movieDao.findByRating(rating);
        for (Movie movie : tempMovieList) {
            System.out.println(movie.getMovieName() + " has a rating of "+ movie.getRating());
        }
        return tempMovieList;
    }
    @Transactional
    public void updateRating(MovieDao movieDao, Integer id,double rating) {
        movieDao.ratingUpdate(id,rating);
    }
    @Transactional
    public void directorNameUpdate(MovieDao movieDao, String dirName) {
        movieDao.directorNameUpdate(dirName);
    }
    @Transactional

    public void removeById(MovieDao movieDao, Integer id) {
        movieDao.removeById(id);
    }
    @Transactional

    public void removeByDirector(MovieDao movieDao, String dirName) {
        movieDao.removeByDirector(dirName);
    }
}
