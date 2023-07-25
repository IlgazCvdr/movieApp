package com.ilgazProject.movieApp;

import com.ilgazProject.movieApp.dao.MovieDao;
import com.ilgazProject.movieApp.entity.Movie;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

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
            System.out.println(movie.getMovieName());
        }
        return tempMovieList;
    }
}
