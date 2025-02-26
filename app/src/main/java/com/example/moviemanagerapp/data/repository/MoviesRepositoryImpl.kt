package com.example.moviemanagerapp.data.repository

import com.example.moviemanagerapp.data.ApiService
import com.example.moviemanagerapp.data.models.Credentials
import com.example.moviemanagerapp.data.models.Movie
import com.example.moviemanagerapp.domain.MoviesRepository
import javax.inject.Inject

class MoviesRepositoryImpl @Inject constructor(
    private val apiService: ApiService

) : MoviesRepository{

    override suspend fun authenticate(credentials: Credentials): String {
        return apiService.authenticate(credentials).data.token
    }

    override suspend fun getMovies(token : String): List<Movie> {
        return apiService.getMovies(token).data
    }


}