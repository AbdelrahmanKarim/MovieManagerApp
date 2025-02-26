package com.example.moviemanagerapp.data
import com.example.moviemanagerapp.data.models.AuthResponseX
import com.example.moviemanagerapp.data.models.Credentials
import com.example.moviemanagerapp.data.models.MovieResponse
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Headers
import retrofit2.http.POST

val k :String = "\"apikey\":"
interface ApiService {


    @Headers("Content-Type: application/json","accept: application/json")
    @POST("login")
    suspend fun authenticate (@Body credentials: Credentials) : AuthResponseX

    @Headers("accept: application/json")
    @GET("movies")
    suspend fun getMovies(@Header("Authorization") token : String ) : MovieResponse




}