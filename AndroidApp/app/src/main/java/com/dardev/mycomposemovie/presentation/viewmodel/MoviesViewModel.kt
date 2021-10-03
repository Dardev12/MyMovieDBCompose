package com.dardev.mycomposemovie.presentation.viewmodel

import android.util.Log
import androidx.compose.runtime.State
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.dardev.mycomposemovie.common.Resources
import com.dardev.mycomposemovie.domain.model.MovieItem
import com.dardev.mycomposemovie.domain.use_case.get_case.GetAllMovie
import com.dardev.mycomposemovie.presentation.viewmodel.state.MovieListState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class MoviesViewModel @Inject constructor(
    private val getAllMovie: GetAllMovie
):ViewModel() {
    private val _state = mutableStateOf(MovieListState())
    val state:State<MovieListState> = _state
    var trendingMovies: List<MovieItem> by mutableStateOf(listOf())

    lateinit var clickedItem: MovieItem

    init {
        getMovies()
    }

    private fun getMovies(){
        getAllMovie().onEach { result->
            when(result){
                is Resources.Success -> {
                    _state.value = MovieListState(movies = result.data )

                    Log.d("MOVIELIST","success ")
                }
                is Resources.Error -> {
                    _state.value = MovieListState(
                        error = result.message ?: "Une erreur s'est produite"
                    )
                    Log.d("MOVIELIST","failure ")
                }
                is Resources.Loading -> {
                    _state.value = MovieListState(isLoading = true)
                }
            }

        }.launchIn(viewModelScope)
    }

    fun itemClicked(item: MovieItem) {
        clickedItem = item
    }
}