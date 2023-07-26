package com.ilgazProject.movieApp.service;

import com.ilgazProject.movieApp.dao.MovieDao;
import com.ilgazProject.movieApp.entity.Movie;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Transactional
@RestController
public class DataController {
    MovieDao movieDao;

    public DataController(MovieDao movieDao) {
        this.movieDao = movieDao;
    }
    @PostMapping("/saveMovie")
    public String createMovie(@RequestBody Movie movie) {
        System.out.println(movie.getMovieName());
        movieDao.save(movie);
        return movie.toString() + " is saved";
    }
    @GetMapping("/find/id")
    public Movie findMovieById(@RequestBody Movie movie) {
        Movie tempMovie = movieDao.findById(movie);
        System.out.println("The movie is found by id. Its values are " + tempMovie.toString());
        return tempMovie;
    }
    @GetMapping("/find/director")
    public List<Movie> findMovieByDirector(@RequestBody Movie movie) {
        List<Movie> tempMovieList = movieDao.findByDirector(movie);
        for (Movie movies : tempMovieList) {
            System.out.println(movies.getMovieName() + " is directed by " + movies.getDirectorName());
        }
        return tempMovieList;
    }
    @GetMapping("find/rating")
    public List<Movie> findMovieByRating(@RequestBody Movie movie) {
        List<Movie> tempMovieList = movieDao.findByRating(movie);
        for (Movie movies : tempMovieList) {
            System.out.println(movies.getMovieName() + " has a rating of " + movies.getRating());
        }
        return tempMovieList;
    }
    @PutMapping("/update/rating")
    public String updateRating(@RequestBody Movie movie) {
        movieDao.ratingUpdate(movie);
        return "The movie with id "+movie.getId() + "'s rating has updated to" + movie.getRating();
    }

    @DeleteMapping("/remove/id")
    public String removeById(@RequestBody Movie movie) {
        movieDao.removeById(movie);
        return movie.getId() + " has been deleted";
    }
    @DeleteMapping("/remove/director")
    public String removeByDirector(@RequestBody Movie movie) {
        movieDao.removeByDirector(movie);
        return "Every movie that has been directed by "+movie.getDirectorName() + " has been deleted";
    }
}
