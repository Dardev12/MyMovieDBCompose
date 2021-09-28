package com.dardev.mycomposemovie.domain.repository

import com.dardev.mycomposemovie.domain.model.MovieItem
import com.dardev.mycomposemovie.domain.model.MovieReponse

interface IComposeMovieRepository {

    suspend fun getAllMovie():List<MovieReponse>
}