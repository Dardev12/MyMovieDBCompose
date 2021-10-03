package com.dardev.mycomposemovie.data.remote

import com.dardev.mycomposemovie.data.remote.dto.MoviesDTO
import com.dardev.mycomposemovie.domain.model.MovieReponse
import retrofit2.http.GET

private const val apiKey="a899396350e175a041f901fe49a15863"

interface MovieDBApi {
    @GET("trending/all/day?api_key=a899396350e175a041f901fe49a15863")
    suspend fun getAllMovieList():MoviesDTO
}