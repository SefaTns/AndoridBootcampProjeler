package com.example.recyclerviewodev.data.repositories

import com.example.recyclerviewodev.data.datasource.MoviesDataSource
import com.example.recyclerviewodev.data.entities.Movies

class MoviesRepository (var moviesDataSource: MoviesDataSource) {

    suspend fun loadMovies() : List<Movies> = this.moviesDataSource.loadMovies()

    suspend fun loadMoviesBottom() : List<Movies> = this.moviesDataSource.loadMoviesBottom()
}