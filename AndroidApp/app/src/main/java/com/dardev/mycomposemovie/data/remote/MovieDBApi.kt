package com.dardev.mycomposemovie.data.remote

import retrofit2.http.GET

private const val apiKey="a899396350e175a041f901fe49a15863"

interface MovieDBApi {
    @GET("trending/all/day?api_key=$apiKey")
    suspend fun getAllMovieList()
}