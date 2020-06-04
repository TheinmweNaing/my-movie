package com.naing.themovie.model.dto

import com.fasterxml.jackson.annotation.JsonProperty


data class Movie(
    @JsonProperty("id")
    val id: Int,
    @JsonProperty("title")
    val title: String,
    @JsonProperty("overview")
    val overview: String,
    @JsonProperty("genre_ids")
    val genreIds: List<Int>,
    @JsonProperty("poster_path")
    val posterPath: String,
    @JsonProperty("vote_average")
    val voteAverage: Int,
    @JsonProperty("release_date")
    val releaseDate: String
)