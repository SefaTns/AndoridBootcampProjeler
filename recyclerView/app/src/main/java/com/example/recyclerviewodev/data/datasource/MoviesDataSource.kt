package com.example.recyclerviewodev.data.datasource

import com.example.recyclerviewodev.data.entities.Movies
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class MoviesDataSource {
    suspend fun loadMovies() : List<Movies> = withContext(Dispatchers.IO){

        val list = ArrayList<Movies>()
        list.add(Movies(1, "Interstellar", "interstellar_r1"))
        list.add(Movies(2,"Anadoluda","anadoluda_r1"))
        list.add(Movies(3, "Django", "django_r1"))
        list.add(Movies(4,"Inception","inception_r1"))
        list.add(Movies(5,"The Pianist","thepianist_r1"))

        return@withContext list
    }

    suspend fun loadMoviesBottom() : List<Movies> = withContext(Dispatchers.IO){

        val list = ArrayList<Movies>()
        list.add(Movies(1, "Interstellar", "interstellar"))
        list.add(Movies(2,"Anadoluda","anadoluda"))
        list.add(Movies(3, "Django", "django"))
        list.add(Movies(4,"Inception","inception"))
        list.add(Movies(5,"The Pianist","thepianist"))

        return@withContext list
    }
}