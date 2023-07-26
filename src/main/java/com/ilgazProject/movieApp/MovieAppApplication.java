package com.ilgazProject.movieApp;

import com.ilgazProject.movieApp.dao.MovieDao;
import com.ilgazProject.movieApp.service.DataController;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class MovieAppApplication {
    public static void main(String[] args) {
        SpringApplication.run(MovieAppApplication.class, args);
    }



}
