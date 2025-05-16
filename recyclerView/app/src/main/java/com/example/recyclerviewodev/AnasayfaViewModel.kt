package com.example.recyclerviewodev

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.recyclerviewodev.data.entities.Movies
import com.example.recyclerviewodev.data.repositories.MoviesRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AnasayfaViewModel @Inject constructor(var moviesRepository : MoviesRepository) : ViewModel() {

    //var moviesRepository = MoviesRepository()
    var moviesList = MutableLiveData<List<Movies>>()
    var moviesListBottom = MutableLiveData<List<Movies>>()

    init {
        loadMovies()
        loadMoviesBottom()
    }

    fun loadMovies() {
        CoroutineScope(Dispatchers.Main).launch {
            moviesList.value = moviesRepository.loadMovies()
        }
    }

    fun loadMoviesBottom() {
        CoroutineScope(Dispatchers.Main).launch {
            moviesListBottom.value = moviesRepository.loadMoviesBottom()
        }
    }
}