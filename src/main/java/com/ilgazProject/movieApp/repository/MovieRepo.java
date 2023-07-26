package com.ilgazProject.movieApp.repository;

import com.ilgazProject.movieApp.entity.Movie;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MovieRepo extends JpaRepository<Movie, Integer> {
}
