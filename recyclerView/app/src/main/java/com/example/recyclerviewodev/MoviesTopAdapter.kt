package com.example.recyclerviewodev

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.recyclerviewodev.data.entities.Movies
import com.example.recyclerviewodev.databinding.CardTasarimBinding

class MoviesTopAdapter (
    var mContext: Context,
    var movieList: List<Movies>,
    var viewModel: AnasayfaViewModel
) : RecyclerView.Adapter<MoviesTopAdapter.CardTasarimTutucu>(){

    inner class CardTasarimTutucu(var tasarim : CardTasarimBinding) : RecyclerView.ViewHolder(tasarim.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CardTasarimTutucu {
        val tasarim = CardTasarimBinding.inflate(LayoutInflater.from(mContext), parent, false)
        return CardTasarimTutucu(tasarim)
    }

    override fun onBindViewHolder(holder: CardTasarimTutucu, position: Int) {
        val movie = movieList.get(position)
        val t = holder.tasarim

        t.imageViewTop.setImageResource(
            mContext.resources.getIdentifier(movie.resim, "drawable", mContext.packageName)
        )
    }

    override fun getItemCount(): Int {
        return movieList.size
    }
}