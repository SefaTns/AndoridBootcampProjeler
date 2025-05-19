package com.example.todoapp.ui.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import com.example.todoapp.R
import com.example.todoapp.databinding.FragmentDetailBinding
import com.example.todoapp.ui.viewmodel.DetailViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class DetailFragment : Fragment() {

    private lateinit var binding: FragmentDetailBinding
    private lateinit var viewModel: DetailViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentDetailBinding.inflate(inflater, container, false)

        val bundle : DetailFragmentArgs by navArgs()
        var getWork = bundle

        binding.editTextUpdate.setText(getWork.work.work_name)

        binding.buttonUpdate.setOnClickListener {

            val work_id = getWork.work.work_id
            val work_name = binding.editTextUpdate.text.toString()
            viewModel.update(work_id, work_name)
        }

        return binding.root
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val temViewModel : DetailViewModel by viewModels()
        this.viewModel = temViewModel
    }
}