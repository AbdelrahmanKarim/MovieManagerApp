package com.example.moviemanagerapp.presentation

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.moviemanagerapp.data.models.Credentials
import com.example.moviemanagerapp.data.models.Movie
import com.example.moviemanagerapp.domain.MoviesRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MoviesViewModel @Inject constructor(
    private val repository: MoviesRepository
)  : ViewModel() {
    private val _movies = MutableStateFlow<List<Movie>>(emptyList())
    val movies : StateFlow<List<Movie>> = _movies.asStateFlow()

    init {
        fetchMovies()
    }


    private fun fetchMovies(){
        viewModelScope.launch {

            val token = repository.authenticate(
                credentials = Credentials("fbfad95e-4aec-4b44-8111-ea7eb3b7c319")
            )


            Log.d("token","tk $token" )
            _movies.value =repository.getMovies("Bearer " + token)



        }




    }





}