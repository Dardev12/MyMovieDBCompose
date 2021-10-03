package com.dardev.mycomposemovie.presentation.components

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import coil.compose.rememberImagePainter
import com.dardev.mycomposemovie.common.Constants
import com.dardev.mycomposemovie.domain.model.MovieItem
import com.dardev.mycomposemovie.domain.model.MovieReponse
import com.google.accompanist.coil.rememberCoilPainter


@ExperimentalFoundationApi
@Composable
fun MovieList(
    movieList: List<MovieItem>
){
    var listState = rememberLazyListState()
    LazyColumn(state = listState){
        stickyHeader { 
            MainHeader()
        }
        itemsIndexed(movieList){index, item ->  
            ListViewItem(movieItem = item,Modifier.background(Color.White))
        }
    }
}

@Composable
fun MainHeader(){
    Surface(
        Modifier
            .fillMaxWidth()
            .background(MaterialTheme.colors.background)
    ) {
        Text(
            text = "Liste de Film",
            style = MaterialTheme.typography.h4,
            textAlign = TextAlign.Center
        )
    }
}

@Composable
fun ListViewItem(
    movieItem: MovieItem,
    modifier: Modifier
){
    Card(modifier = modifier) {
        Row(verticalAlignment = Alignment.CenterVertically) {
            MovieImageBanner(imagePath = movieItem.backdropPath)
            MovieMetadataItem(movieItem = movieItem)
        }
    }
}

@Composable
fun MovieMetadataItem(movieItem: MovieItem){
    Column(modifier = Modifier
        .fillMaxSize()
        .padding(start = 10.dp)
    ) {
        movieItem?.title?.let {
            Text(text = it)
            Text(
                text = movieItem.voteAverage,
                style = MaterialTheme.typography.body1
            )
        }
    }
}

@Composable
fun MovieImageBanner(imagePath:String){
    Image(
        modifier= Modifier
            .width(182.dp)
            .height(100.dp),
        painter= rememberImagePainter(
            Constants.BASE_IMAGE_URL + imagePath
        ),
        contentDescription = ""
    )
}