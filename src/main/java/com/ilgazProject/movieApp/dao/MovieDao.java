package com.ilgazProject.movieApp.dao;


import com.ilgazProject.movieApp.entity.Movie;

public interface MovieDao {
    //crud
    void save(Movie movie);//create
    Movie findById(Integer id);//read
    //find by rating ratingin yuksekligine gore fln alma metodu kur :data diye olay var sonradan variable eklemk icin
    //find by director name yonetmenin yonettigi filmleri bul
    void update(Integer id , Movie movie);//update
    void remove(Integer id);//delete



}
