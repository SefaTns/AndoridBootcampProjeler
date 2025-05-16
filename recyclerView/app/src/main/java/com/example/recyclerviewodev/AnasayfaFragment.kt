package com.example.recyclerviewodev

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModel
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.example.recyclerviewodev.databinding.FragmentAnasayfaBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class AnasayfaFragment : Fragment() {

    private lateinit var binding : FragmentAnasayfaBinding
    private lateinit var viewModel: AnasayfaViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentAnasayfaBinding.inflate(inflater, container, false)

        viewModel.moviesList.observe(viewLifecycleOwner) {
            val moviesTopAdapter = MoviesTopAdapter(requireContext(), it, viewModel)
            binding.rvTop.adapter = moviesTopAdapter
        }

        binding.rvTop.layoutManager = StaggeredGridLayoutManager(1, StaggeredGridLayoutManager.HORIZONTAL)

        viewModel.moviesListBottom.observe(viewLifecycleOwner) {
            val moviesBottomAdapter = MoviesBottomAdapter(requireContext(), it, viewModel)
            binding.rvBottom.adapter = moviesBottomAdapter
        }

        binding.rvBottom.layoutManager = StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL)

        return binding.root
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val tempViewModel : AnasayfaViewModel by viewModels()
        viewModel = tempViewModel
    }

    override fun onResume() {
        super.onResume()
        viewModel.loadMovies()
        viewModel.loadMoviesBottom()
    }
}

