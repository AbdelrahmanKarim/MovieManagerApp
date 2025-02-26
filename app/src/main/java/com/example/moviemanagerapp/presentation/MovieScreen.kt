package com.example.moviemanagerapp.presentation

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.hilt.navigation.compose.hiltViewModel
import coil3.compose.AsyncImage
import coil3.compose.rememberAsyncImagePainter
import coil3.request.ImageRequest
import coil3.request.lifecycle
import coil3.request.placeholder
import com.example.moviemanagerapp.R
import com.example.moviemanagerapp.data.models.Movie


@Composable
fun MoviesScreen(viewModel: MoviesViewModel = hiltViewModel()) {

    val movies by viewModel.movies.collectAsState()
    val context = LocalContext.current


    LazyColumn {
        items(movies, key = {movie:Movie -> movie.id} ) { movie ->

            Card {
                Column {
                    Text(text = movie.name)
                    AsyncImage(model = ImageRequest.Builder(context = context).data("https://thetvdb.com/"+movie.image).placeholder(
                        R.drawable.ic_launcher_background).build()
                        , contentDescription = null)



                }

            }

        }
    }



}



