package com.dardev.mycomposemovie

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import com.dardev.mycomposemovie.presentation.ui.theme.MyComposeMovieTheme
import com.dardev.mycomposemovie.presentation.viewmodel.MoviesViewModel
import com.dardev.mycomposemovie.presentation.views.MainMoviesView
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    @ExperimentalFoundationApi
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyComposeMovieTheme {
                // A surface container using the 'background' color from the theme
                Surface(color = MaterialTheme.colors.background) {
                    MainMoviesView()
                }
            }
        }
    }
}

