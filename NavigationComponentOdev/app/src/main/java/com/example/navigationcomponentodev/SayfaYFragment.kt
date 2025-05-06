package com.example.navigationcomponentodev

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.OnBackPressedCallback
import androidx.navigation.Navigation
import androidx.navigation.fragment.findNavController
import com.example.navigationcomponentodev.databinding.FragmentSayfaYBinding

class SayfaYFragment : Fragment() {

    private lateinit var binding: FragmentSayfaYBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentSayfaYBinding.inflate(inflater, container, false)

        val backPress = object : OnBackPressedCallback(true) {

            override fun handleOnBackPressed() {

                findNavController().navigate(R.id.anasayfaGecis)
            }
        }
        requireActivity().onBackPressedDispatcher.addCallback(viewLifecycleOwner, backPress)

        return binding.root
    }
}