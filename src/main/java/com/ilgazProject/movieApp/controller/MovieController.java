package com.ilgazProject.movieApp.controller;

import com.ilgazProject.movieApp.dao.MovieDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MovieController {
    @Autowired
    private MovieDao movieDao;


}
