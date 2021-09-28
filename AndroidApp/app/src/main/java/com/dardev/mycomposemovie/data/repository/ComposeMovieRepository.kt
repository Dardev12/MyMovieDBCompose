package com.dardev.mycomposemovie.data.repository

import com.dardev.mycomposemovie.data.remote.MovieDBApi
import com.dardev.mycomposemovie.domain.model.MovieReponse
import com.dardev.mycomposemovie.domain.repository.IComposeMovieRepository
import javax.inject.Inject

class ComposeMovieRepository @Inject constructor(
        private val api:MovieDBApi
):IComposeMovieRepository {
    override suspend fun getAllMovie(): List<MovieReponse> {
        return api.getAllMovieList()
    }

}