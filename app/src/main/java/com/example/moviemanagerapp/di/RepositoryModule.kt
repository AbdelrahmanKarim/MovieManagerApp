package com.example.moviemanagerapp.di

import com.example.moviemanagerapp.data.ApiService
import com.example.moviemanagerapp.data.repository.MoviesRepositoryImpl
import com.example.moviemanagerapp.domain.MoviesRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {

    @Provides
    @Singleton
    fun provideMoviesRepository(apiService: ApiService): MoviesRepository =
        MoviesRepositoryImpl(apiService)
}