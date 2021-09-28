package com.dardev.mycomposemovie.domain.model

data class MovieItem(
    var backdropPath:String,
    var id:String,
    var originalTitle:String,
    var overview:String,
    var posterPath:String,
    var releaseDate:String,
    var title:String?,
    var voteAverage:String
    )
