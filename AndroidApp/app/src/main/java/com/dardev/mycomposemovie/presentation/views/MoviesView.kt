package com.dardev.mycomposemovie.presentation.views

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.dardev.mycomposemovie.presentation.components.MovieList
import com.dardev.mycomposemovie.presentation.viewmodel.MoviesViewModel

@ExperimentalFoundationApi
@Composable
fun MainMoviesView(moviesViewModel: MoviesViewModel= hiltViewModel()){
    val state=moviesViewModel.state.value
    MovieList(movieList = state.movies!!.results )
    if (state.error.isNotBlank()){
        Text(
            text = state.error,
            color = MaterialTheme.colors.error,
            textAlign = TextAlign.Center,
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 20.dp)

        )
    }
    if (state.isLoading){
        CircularProgressIndicator()
    }
}