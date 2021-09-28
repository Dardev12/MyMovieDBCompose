package com.dardev.mycomposemovie.data.remote.dto

import com.dardev.mycomposemovie.domain.model.MovieItem
import com.dardev.mycomposemovie.domain.model.MovieReponse

data class MoviesDTO(
    val page: Int,
    val results: List<Result>,
    val total_pages: Int,
    val total_results: Int
)

fun MoviesDTO.toMovieReponse():MovieReponse{
    var listMovieItem:List<MovieItem> = emptyList()

    results.forEach{item->
        listMovieItem.map{
            item.toMovie()
        }
    }
    return MovieReponse(
        page=page.toString(),
        results = listMovieItem,
    )
}