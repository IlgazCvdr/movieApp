package com.ilgazProject.movieApp.entity;

import jakarta.persistence.*;
import jdk.jfr.DataAmount;
import org.antlr.v4.runtime.misc.NotNull;

@Entity
@Table(name = "movies")
public class Movie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private int id;

    @Column(name = "director_name")
    private String directorName;
    @Column(name = "movie_name", nullable = false)
    private String movieName;

    @Column(name = "rating")
    private Double rating;


    public Movie(){
        this.directorName = null;
        this.movieName = "";
        rating = null;
    }
    public Movie(String directorName, String movieName, Double rating) {
        this.directorName = directorName;
        this.movieName = movieName;
        this.rating = rating;
    }
    public Movie(Integer id,String directorName, String movieName, Double rating){
        this.id = id;
        this.directorName = directorName;
        this.movieName = movieName;
        this.rating = rating;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDirectorName() {
        return directorName;
    }

    public void setDirectorName(String directorName) {
        this.directorName = directorName;
    }

    public String getMovieName() {
        return movieName;
    }

    public void setMovieName(String movieName) {
        this.movieName = movieName;
    }

    public Double getRating() {
        return rating;
    }

    public void setRating(Double rating) {
        this.rating = rating;
    }

    @Override
    public String toString() {
        return "Movies{" +
                "id=" + id +
                ", directorName='" + directorName + '\'' +
                ", movieName='" + movieName + '\'' +
                ", rating=" + rating +
                '}';
    }
}
