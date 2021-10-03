package com.dardev.mycomposemovie.data.remote.dto

import com.dardev.mycomposemovie.domain.model.MovieItem
import com.dardev.mycomposemovie.domain.model.MovieReponse
import com.google.gson.annotations.SerializedName

data class MoviesDTO(
    val page: String,
    val results: List<Result>,
    @SerializedName("total_pages")
    val totalPages: Int,
    @SerializedName("total_results")
    val totalResults: Int
)

fun MoviesDTO.toMovieReponse():MovieReponse{
    var listMovieItem:List<MovieItem> = emptyList()

    results.forEach{item->
        listMovieItem.map{
            item.toMovie()
        }
    }
    return MovieReponse(
        page=page,
        results = listMovieItem,
    )
}