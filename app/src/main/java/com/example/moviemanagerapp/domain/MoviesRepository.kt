package com.example.moviemanagerapp.domain

import com.example.moviemanagerapp.data.models.Credentials
import com.example.moviemanagerapp.data.models.Movie

interface MoviesRepository {
    suspend fun authenticate(credentials: Credentials) : String
    suspend fun getMovies(token : String): List<Movie>


}