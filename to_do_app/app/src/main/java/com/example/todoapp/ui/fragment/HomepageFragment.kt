package com.example.todoapp.ui.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.SearchView
import androidx.fragment.app.viewModels
import androidx.navigation.Navigation
import com.example.todoapp.R
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.todoapp.databinding.FragmentHomepageBinding
import com.example.todoapp.ui.adapter.WorksAdapter
import com.example.todoapp.ui.viewmodel.HomepageViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomepageFragment : Fragment() {

    private lateinit var binding: FragmentHomepageBinding
    private lateinit var viewModel : HomepageViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentHomepageBinding.inflate(inflater,container, false)

        viewModel.worksList.observe(viewLifecycleOwner) {
            val worksAdapter = WorksAdapter(requireContext(), it, viewModel)
            binding.rwHomepage.adapter = worksAdapter
        }

        binding.rwHomepage.layoutManager = LinearLayoutManager(requireContext())

        binding.fab.setOnClickListener {
            Navigation.findNavController(it).navigate(R.id.registry_nav)
        }

        binding.searchView.setOnQueryTextListener(object :
            android.widget.SearchView.OnQueryTextListener {
                override fun onQueryTextChange(newText: String): Boolean {
                    viewModel.search(newText)
                    return true
                }

                override fun onQueryTextSubmit(query: String): Boolean {
                    viewModel.search(query)
                    return true
                }

            })

        return binding.root
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val tempViewModel : HomepageViewModel by viewModels()
        this.viewModel = tempViewModel
    }

    override fun onResume() {
        super.onResume()
        this.viewModel.loadWorks()
    }
}