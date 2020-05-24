package com.naing.themovie.model.service

import com.naing.themovie.model.api.MovieAPI
import com.naing.themovie.model.dto.Genres
import com.naing.themovie.model.dto.Movie
import io.reactivex.Observable

class MovieService(private val api: MovieAPI) {

    fun getPopular(): Observable<Movie> {
        return api.getPopular()
    }

    fun getNowPlaying(): Observable<Movie> {
        return api.getNowPlaying()
    }

    fun getUpComing(): Observable<Movie> {
        return api.getUpComing()
    }

    fun getTopRated(): Observable<Movie> {
        return api.getTopRated()
    }

    fun getGenres(): Observable<Genres> {
        return api.getGenres()
    }
}