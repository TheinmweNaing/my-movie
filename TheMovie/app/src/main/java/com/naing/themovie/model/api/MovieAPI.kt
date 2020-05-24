package com.naing.themovie.model.api

import com.naing.themovie.model.RetrofitManager.API_KEY
import com.naing.themovie.model.dto.Genres
import com.naing.themovie.model.dto.Movie
import io.reactivex.Observable
import retrofit2.http.GET

interface MovieAPI {

    @GET("movie/popular$API_KEY")
    fun getPopular(): Observable<Movie>

    @GET("movie/now_playing$API_KEY")
    fun getNowPlaying(): Observable<Movie>

    @GET("movie/upcoming$API_KEY")
    fun getUpComing(): Observable<Movie>

    @GET("movie/top_rated$API_KEY")
    fun getTopRated(): Observable<Movie>

    @GET("genre/movie/list$API_KEY")
    fun getGenres(): Observable<Genres>
}