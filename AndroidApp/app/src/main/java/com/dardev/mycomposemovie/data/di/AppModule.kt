package com.dardev.mycomposemovie.data.di

import com.dardev.mycomposemovie.common.Constants
import com.dardev.mycomposemovie.data.remote.MovieDBApi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideMovieDBCompose(): MovieDBApi{
        return Retrofit.Builder()
            .baseUrl(Constants.MOVIE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(MovieDBApi::class.java)
    }



}