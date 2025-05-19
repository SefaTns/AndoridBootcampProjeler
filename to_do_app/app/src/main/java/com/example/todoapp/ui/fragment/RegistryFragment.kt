package com.example.todoapp.ui.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.example.todoapp.R
import com.example.todoapp.databinding.FragmentHomepageBinding
import com.example.todoapp.databinding.FragmentRegistryBinding
import com.example.todoapp.ui.viewmodel.RegistryViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class RegistryFragment : Fragment() {

    private lateinit var binding: FragmentRegistryBinding
    private lateinit var viewModel: RegistryViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentRegistryBinding.inflate(inflater, container, false)

        binding.buttonRegistry.setOnClickListener {
            viewModel.registry(binding.editTextRegistry.text.toString())
        }

        return binding.root
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val tempViewModel : RegistryViewModel by viewModels()
        this.viewModel = tempViewModel
    }
}