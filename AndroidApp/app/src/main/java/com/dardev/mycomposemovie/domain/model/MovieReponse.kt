package com.dardev.mycomposemovie.domain.model

data class MovieReponse(
    var page:String,
    var results:List<MovieItem>
)