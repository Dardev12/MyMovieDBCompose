package com.dardev.mycomposemovie.data.remote.dto

import com.dardev.mycomposemovie.domain.model.MovieItem

data class Result(
    val adult: Boolean,
    val backdrop_path: String,
    val first_air_date: String,
    val genre_ids: List<Int>,
    val id: Int,
    val media_type: String,
    val name: String,
    val origin_country: List<String>,
    val original_language: String,
    val original_name: String,
    val original_title: String,
    val overview: String,
    val popularity: Double,
    val poster_path: String,
    val release_date: String,
    val title: String,
    val video: Boolean,
    val vote_average: Double,
    val vote_count: Int
)

fun Result.toMovie():MovieItem{
    return MovieItem(
        backdropPath = backdrop_path,
        id=id.toString(),
        originalTitle = original_title,
        overview = overview,
        posterPath = poster_path,
        releaseDate = release_date,
        title=title,
        voteAverage = vote_average.toString()
    )
}