package com.dardev.mycomposemovie.presentation.viewmodel.state

import com.dardev.mycomposemovie.domain.model.MovieReponse

data class MovieListState(
    val isLoading:Boolean = false,
    val movies: MovieReponse? = null,
    val error:String = ""
)
