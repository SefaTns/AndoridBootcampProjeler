package com.example.recyclerviewodev

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.recyclerviewodev.data.entities.Movies
import com.example.recyclerviewodev.databinding.CardTasarimBinding
import com.example.recyclerviewodev.databinding.CardTasarimBottomBinding

class MoviesBottomAdapter (
    var mContext: Context,
    var movieList: List<Movies>,
    var viewModel: AnasayfaViewModel
) : RecyclerView.Adapter<MoviesBottomAdapter.CardTasarimBottomTutucu>(){

    inner class CardTasarimBottomTutucu(var tasarim : CardTasarimBottomBinding) : RecyclerView.ViewHolder(tasarim.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CardTasarimBottomTutucu {
        val tasarim = CardTasarimBottomBinding.inflate(LayoutInflater.from(mContext), parent, false)
        return CardTasarimBottomTutucu(tasarim)
    }

    override fun onBindViewHolder(holder: CardTasarimBottomTutucu, position: Int) {
        val movie = movieList.get(position)
        val t = holder.tasarim

        t.imageViewBottom.setImageResource(
            mContext.resources.getIdentifier(movie.resim, "drawable", mContext.packageName)
        )
    }

    override fun getItemCount(): Int {
        return movieList.size
    }
}