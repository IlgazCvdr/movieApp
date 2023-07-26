package com.ilgazProject.movieApp.controller;

import com.ilgazProject.movieApp.entity.Movie;
import com.ilgazProject.movieApp.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Service
@Transactional
@RequestMapping("/api")
@RestController
public class MovieController {
    @Autowired
    private MovieService movieService;
    @PostMapping("/movies")
    public String createMovie(@RequestBody Movie movie) {
        System.out.println(movie.getMovieName());
        movieService.createMovie(movie);
        return movie.toString() + " is saved";
    }
    @GetMapping("/movies/id")
    public Movie findMovieById(@RequestBody Movie movie) {
        Movie tempMovie = movieService.findMovieById(movie);
        System.out.println("The movie is found by id. Its values are " + tempMovie.toString());
        return tempMovie;
    }
    @GetMapping("/movies/director")
    public List<Movie> findMovieByDirector(@RequestBody Movie movie) {
        List<Movie> tempMovieList = movieService.findMovieByDirector(movie);
        for (Movie movies : tempMovieList) {
            System.out.println(movies.getMovieName() + " is directed by " + movies.getDirectorName());
        }
        return tempMovieList;
    }
    @GetMapping("/movies/rating")
    public List<Movie> findMovieByRating(@RequestBody Movie movie) {
        List<Movie> tempMovieList = movieService.findMovieByRating(movie);
        for (Movie movies : tempMovieList) {
            System.out.println(movies.getMovieName() + " has a rating of " + movies.getRating());
        }
        return tempMovieList;
    }
    @PutMapping("/movies")
    public String updateRating(@RequestBody Movie movie) {
        //by id
        return movieService.updateRating(movie);
    }

    @DeleteMapping("/movies/{movieId}")
    public String removeById(@RequestParam Integer movieId) {
        movieService.removeById(new Movie(movieId,"","",0.0));
        return movieId + " has been deleted";
    }
    @DeleteMapping("/movies")
    public String removeByDirector(@RequestBody Movie movie) {
        movieService.removeByDirector(movie);
        return "Every movie that has been directed by "+movie.getDirectorName() + " has been deleted";
    }


}
