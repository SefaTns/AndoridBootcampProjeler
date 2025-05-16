package com.example.recyclerviewodev.di

import com.example.recyclerviewodev.data.datasource.MoviesDataSource
import com.example.recyclerviewodev.data.repositories.MoviesRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class AppModule {

    @Provides
    @Singleton
    fun provideMoviesRepository(moviesDataSource: MoviesDataSource) : MoviesRepository {
        return MoviesRepository(moviesDataSource)
    }


    @Provides
    @Singleton
    fun provideMoviesDataSource() : MoviesDataSource {
        return MoviesDataSource()
    }


}